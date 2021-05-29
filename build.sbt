import sbt.Keys._
import play.sbt.PlaySettings.serviceSettings

lazy val root = (project in file("."))
  .enablePlugins(PlayService, PlayLayoutPlugin, Common)
  .settings(
    name := "ledger",
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      "org.joda" % "joda-convert" % "2.2.1",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      jdbc,
        "org.playframework.anorm" %% "anorm" % "2.6.4"
    ),
    libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41",
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
