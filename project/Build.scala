import sbt.Keys._
import sbt._

object RootBuild extends Build {
  val liftVersion = SettingKey[String]("liftVersion", "Full version number of the Lift Web Framework")
  val liftEdition = SettingKey[String]("liftEdition", "Lift Edition (short version number to append to artifact name)")
  val passcode    = SettingKey[String]("passcode",    "Presenter's passcode")

  def passcodeResolve:String = {
    val jvmProp = Option(System.getProperty("presentera.passcode"))
    val envProp = Option(System.getenv("presentera_passcode"))
    val default = Some("PresenteraMetal!")

    List(jvmProp, envProp, default).flatten.head
  }

  lazy val project = Project(
    id = "presentera",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      liftEdition <<= liftVersion { _.substring(0,3) },
      passcode <<= passcode ?? passcodeResolve
    )
  )
}
