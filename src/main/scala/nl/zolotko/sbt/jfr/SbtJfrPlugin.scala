package nl.zolotko.sbt.jfr

import Encoders.{flightRecorderOptions, startFlightRecording}
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin

object SbtJfrPlugin extends AutoPlugin {
  override def trigger = allRequirements

  override def requires = JvmPlugin

  trait JfrEnabledMode

  object autoImport {
    val jfrRecordings      = settingKey[Seq[JfrRecording]]("List of JFR recordings to be started")
    val jfrRecorderOptions = settingKey[Option[JfrRecorderOptions]]("Options that control the behavior of JFR")
  }

  import autoImport._

  override lazy val globalSettings = Seq(
    jfrRecordings := Seq.empty,
    jfrRecorderOptions := None
  )

  override def projectSettings: Seq[Def.Setting[_]] =
    javaOptions ++=
      jfrRecordings.value.map(startFlightRecording) ++
        jfrRecorderOptions.value.map(flightRecorderOptions)
}
