name := "presentera"

version := "0.1.0"

organization := "net.liftweb"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  "snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "https://oss.sonatype.org/content/repositories/releases"
)

seq(webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

liftVersion <<= liftVersion ?? "3.0-M3"

libraryDependencies ++= {
  val lv = liftVersion.value
  val le = liftEdition.value
  Seq(
    "net.liftweb"       %% "lift-webkit"        % lv                % "compile",
    "net.liftmodules"   %% ("lift-jquery-module_"+le) % "2.9-SNAPSHOT",
    "org.eclipse.jetty" % "jetty-webapp"        % "8.1.7.v20120910"  % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.specs2"              %% "specs2-core"              % "3.0"                 % "test"
  )
}

buildInfoSettings

sourceGenerators in Compile <+= buildInfo

buildInfoKeys := Seq[BuildInfoKey](passcode)

buildInfoPackage := "code.build"
