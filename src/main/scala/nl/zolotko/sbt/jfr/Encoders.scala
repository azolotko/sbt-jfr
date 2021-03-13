package nl.zolotko.sbt.jfr

import java.nio.file.Path
import scala.concurrent.duration.FiniteDuration

object Encoders {
  def startFlightRecording(jfrRecording: JfrRecording): String = {
    import jfrRecording._

    val params = parameters(
      Map(
        "delay"            -> delay.map(finiteDuration),
        "disk"             -> disk.map(boolean),
        "dumponexit"       -> dumpOnExit.map(boolean),
        "duration"         -> duration.map(finiteDuration),
        "filename"         -> fileName.map(path),
        "name"             -> name,
        "maxage"           -> maxAge.map(finiteDuration),
        "maxsize"          -> maxSize.map(size),
        "path-to-gc-roots" -> pathToGcRoots.map(boolean),
        "settings"         -> settings.map(path)
      )
    )

    s"-XX:StartFlightRecording=$params"
  }

  def flightRecorderOptions(jfrRecorderOptions: JfrRecorderOptions): String = {
    import jfrRecorderOptions._

    val params = parameters(
      Map(
        "globalbuffersize"      -> globalBufferSize.map(size),
        "maxchunksize"          -> maxChunkSize.map(size),
        "memorysize"            -> memorySize.map(size),
        "numglobalbuffers"      -> numGlobalBuffers.map(count),
        "old-object-queue-size" -> oldObjectQueueSize.map(size),
        "repository"            -> repository.map(path),
        "retransform"           -> retransform.map(boolean),
        "samplethreads"         -> sampleThreads.map(boolean),
        "stackdepth"            -> stackDepth.map(count),
        "threadbuffersize"      -> threadBufferSize.map(size)
      )
    )

    s"-XX:FlightRecorderOptions=$params"
  }

  private def finiteDuration(d: FiniteDuration): String =
    s"${d.toSeconds}s"

  private def boolean(b: Boolean): String =
    b.toString

  private def path(p: Path): String =
    p.toString

  private def size(s: Long): String =
    s.toString

  private def count(c: Int): String =
    c.toString

  private def parameters(params: Map[String, Option[String]]): String =
    params.collect { case (name, Some(value)) => s"$name=$value" }.mkString(",")
}
