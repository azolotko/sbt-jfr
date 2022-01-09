name := "sbt-jfr"

organization := "nl.zolotko.sbt"

licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/azolotko/sbt-jfr"))

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

sbtPlugin := true

scalacOptions += "-target:jvm-1.8"

enablePlugins(SbtPlugin)

scriptedBufferLog := false

scriptedLaunchOpts := (
  scriptedLaunchOpts.value ++
    Seq("-Xmx1g", "-Dsbt.jfr.version=" + version.value)
)

publishTo := sonatypePublishToBundle.value

sonatypeCredentialHost := "s01.oss.sonatype.org"

sonatypeProfileName := "nl.zolotko.sbt"
