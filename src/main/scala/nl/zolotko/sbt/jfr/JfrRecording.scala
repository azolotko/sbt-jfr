package nl.zolotko.sbt.jfr

import java.nio.file.Path
import scala.concurrent.duration.FiniteDuration

/** Describes a JFR recording.
  *
  * @param delay Specifies the delay between the Java application launch time and the start of the recording.
  *              By default, there's no delay.
  * @param disk Specifies whether to write data to disk while recording.
  *             By default, this parameter is true.
  * @param dumpOnExit Specifies if the running recording is dumped when the JVM shuts down.
  *                   By default, this parameter is false.
  * @param duration Specifies the duration of the recording.
  *                 By default, the duration isn't limited.
  * @param fileName Specifies the path and name of the file to which the recording is written when the recording is stopped.
  * @param name Specifies the name and the identifier of a recording.
  * @param maxAge Specifies the maximum age of disk data to keep for the recording.
  *               By default, the maximum age isn't limited.
  * @param maxSize Specifies the maximum size (in bytes) of disk data to keep for the recording.
  *                 By default, the maximum size of disk data isn't limited.
  * @param pathToGcRoots Specifies whether to collect the path to garbage collection roots at the end of a recording.
  *                      By default, this parameter is false.
  * @param settings Specifies the path and name of the event settings file.
  */
case class JfrRecording(
    delay: Option[FiniteDuration] = None,
    disk: Option[Boolean] = None,
    dumpOnExit: Option[Boolean] = None,
    duration: Option[FiniteDuration] = None,
    fileName: Option[Path] = None,
    name: Option[String] = None,
    maxAge: Option[FiniteDuration] = None,
    maxSize: Option[Long] = None,
    pathToGcRoots: Option[Boolean] = None,
    settings: Option[Path] = None
)
