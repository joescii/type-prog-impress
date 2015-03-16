import sbt.Keys._
import sbt._

object RootBuild extends Build {
  val liftVersion = SettingKey[String]("liftVersion", "Full version number of the Lift Web Framework")
  val liftEdition = SettingKey[String]("liftEdition", "Lift Edition (short version number to append to artifact name)")
  val passcode    = SettingKey[String]("passcode",    "Presenter's passcode")

  lazy val project = Project(
    id = "presentera",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      liftEdition <<= liftVersion { _.substring(0,3) },
      passcode <<= passcode ?? System.getProperty("presentera.passcode", "PresenteraMetal!")
    )
  )
}
