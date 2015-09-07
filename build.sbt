import NativePackagerKeys._

name := "presentera"

version := "0.1.0"

organization := "net.liftweb"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
)

seq(webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

liftVersion <<= liftVersion ?? "3.0-M6"

libraryDependencies ++= {
  val lv = liftVersion.value
  val le = liftEdition.value
  Seq(
    "net.liftweb"             %% "lift-webkit"              % liftVersion.value     % "compile",
    "net.liftmodules"         %% ("lift-jquery-module_"+le) % "2.9"                 % "compile", // https://github.com/karma4u101/lift-jquery-module
    "org.eclipse.jetty"       % "jetty-webapp"              % "9.2.7.v20150116"     % "compile",
    "org.eclipse.jetty"       % "jetty-plus"                % "9.2.7.v20150116"     % "container,test", // For Jetty Config
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"          % "logback-classic"           % "1.0.6"               % "runtime",
    "org.scalatest"           %% "scalatest"                % "2.2.4"               % "test->*",
    "org.seleniumhq.selenium" %  "selenium-java"            % "2.46.0"              % "test"
  )
}

packageArchetype.java_application

bashScriptConfigLocation := Some("${app_home}/../conf/jvmopts")

initialize~= { _ =>
  System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe")
}

(Keys.test in Test) <<= (Keys.test in Test) dependsOn (start in container.Configuration)
