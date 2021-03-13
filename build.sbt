name := "sbt-jfr"

organization := "nl.zolotko.sbt"

licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/azolotko/sbt-jfr"))

publishTo := sonatypePublishToBundle.value

developers := List(
  Developer("azolotko", "Alex Zolotko", "azolotko@gmail.com", url("https://github.com/azolotko"))
)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/azolotko/sbt-jfr"),
    "scm:git:https://github.com/azolotko/sbt-jfr.git",
    Some("scm:git:git@github.com:azolotko/sbt-jfr.git")
  )
)

sonatypeProfileName := "nl.zolotko.sbt"

scalacOptions := Seq("-deprecation", "-unchecked", "-feature")

sbtPlugin := true

enablePlugins(SbtPlugin)

scriptedBufferLog := false

scriptedLaunchOpts := (
  scriptedLaunchOpts.value ++
    Seq("-Xmx1g", "-Dsbt.jfr.version=" + version.value)
)
