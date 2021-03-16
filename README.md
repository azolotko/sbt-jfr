# sbt-jfr

***sbt-jfr*** is an sbt plugin to configure [Java Flight Recorder](https://openjdk.java.net/jeps/328) via command-line arguments.

## Usage

Add the following settings to your `project/plugins.sbt`:

```sbt
addSbtPlugin("nl.zolotko.sbt" % "sbt-jfr" % "latest.release")
```

The latest version is [![Maven Central](https://maven-badges.herokuapp.com/maven-central/nl.zolotko.sbt/sbt-jfr/badge.svg?subject=sbt-jfr)](https://maven-badges.herokuapp.com/maven-central/nl.zolotko.sbt/sbt-jfr/)

An example of `build.sbt` with two JFR recordings and overridden JFR recorder options:

```sbt
import nl.zolotko.sbt.jfr.{JfrRecording, JfrRecorderOptions}
import scala.concurrent.duration.DurationInt

lazy val root = (project in file("."))
  .settings(
    version := "0.1",
    scalaVersion := "2.13.5",
    jfrRecordings := Seq(
      JfrRecording(),
      JfrRecording(
        delay = 20.seconds.some,
        disk = true.some,
        dumpOnExit = true.some,
        duration = 30.seconds.some,
        fileName = file("test-jfr-recording").toPath.some,
        name = "test-jfr-recording".some,
        maxAge = 1.minute.some,
        maxSize = 524288L.some,
        pathToGcRoots = true.some,
        settings = file("settings.jfc").toPath.some
      )
    ),
    jfrRecorderOptions := JfrRecorderOptions(
      globalBufferSize = 524288L.some,
      maxChunkSize = 10485760L.some,
      memorySize = 20971520L.some,
      numGlobalBuffers = 40.some,
      oldObjectQueueSize = 512L.some,
      repository = file("jfr-repository").toPath.some,
      retransform = true.some,
      sampleThreads = true.some,
      stackDepth = 96.some,
      threadBufferSize = 16384L.some
    ).some,
    fork := true
  )
```


## Development

### Run tests

```
sbt scripted
```