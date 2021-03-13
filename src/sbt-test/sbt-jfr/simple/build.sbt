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
