sys.props.get("sbt.jfr.version") match {
  case Some(ver) => addSbtPlugin("nl.zolotko.sbt" % "sbt-jfr" % ver)
  case _ => sys.error("""|The system property 'sbt.jfr.version' is not defined.
                                 |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
}
