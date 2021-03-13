name := "sbt-jfr"

organization := "nl.zolotko"

licenses := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))

sbtPlugin := true

enablePlugins(SbtPlugin)

scriptedBufferLog := false

scriptedLaunchOpts := (
  scriptedLaunchOpts.value ++
    Seq("-Xmx1g", "-Dplugin.version=" + version.value)
)
