lazy val root = project
  .in(file(""))
  .settings(
    name := "advent-of-code",
    scalaVersion := "2.13.3",
    scalacOptions ++= Seq("-deprecation"),
    libraryDependencies ++= Seq(
        "org.scalactic" %% "scalactic" % "3.2.0",
        "org.scalatest" %% "scalatest" % "3.2.0" % "test",
        "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
        "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0" % "test",
        "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
        "com.lihaoyi" %% "ujson" % "0.7.5",
    ),
  )
