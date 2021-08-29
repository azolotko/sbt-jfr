package nl.zolotko.sbt.jfr

import java.nio.file.Path

/** Describes JFR recorder options.
  *
  * @param globalBufferSize
  *   Specifies the total amount of primary memory used for data retention. The default value is based on the value
  *   specified for memorySize.
  * @param maxChunkSize
  *   Specifies the maximum size (in bytes) of the data chunks in a recording. By default, the maximum size of data
  *   chunks is set to 12 MB. The minimum allowed is 1 MB.
  * @param memorySize
  *   Determines how much buffer memory should be used, and sets the globalBufferSize and numGlobalBuffers parameters
  *   based on the size specified. By default, the memory size is set to 10 MB.
  * @param numGlobalBuffers
  *   Specifies the number of global buffers used. The default value is based on the memorySize specified.
  * @param oldObjectQueueSize
  *   Maximum number of old objects to track. By default, the number of objects is set to 256.
  * @param repository
  *   Specifies the repository (a directory) for temporary disk storage. By default, the system's temporary directory is
  *   used.
  * @param retransform
  *   Specifies whether event classes should be retransformed using JVMTI. By default, this parameter is true.
  * @param sampleThreads
  *   Specifies whether thread sampling is enabled. By default, this parameter is true.
  * @param stackDepth
  *   Stack depth for stack traces. By default, the depth is set to 64 method calls. The maximum is 2048.
  * @param threadBufferSize
  *   Specifies the per-thread local buffer size (in bytes). By default, the local buffer size is set to 8096. The
  *   minimum is 4096.
  */
case class JfrRecorderOptions(
    globalBufferSize: Option[Long] = None,
    maxChunkSize: Option[Long] = None,
    memorySize: Option[Long] = None,
    numGlobalBuffers: Option[Int] = None,
    oldObjectQueueSize: Option[Long] = None,
    repository: Option[Path] = None,
    retransform: Option[Boolean] = None,
    sampleThreads: Option[Boolean] = None,
    stackDepth: Option[Int] = None,
    threadBufferSize: Option[Long] = None
)
