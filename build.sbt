name := "rachio-automation"

version := "1.0.0"
scalaVersion := "2.11.8"
libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.2",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.2",
  "io.spray" %% "spray-client" % "1.3.3",
  "io.spray" %%  "spray-json" % "1.3.2",
  "com.typesafe.akka" % "akka-actor_2.11" % "2.4.7"
)
