import jdk.jfr.FlightRecorder

object Main extends App {
  println("Hello, world!")

  System.exit(
    if (FlightRecorder.isAvailable && FlightRecorder.getFlightRecorder.getRecordings.size() == 2)
      0
    else
      1
  )
}
