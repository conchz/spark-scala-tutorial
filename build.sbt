organization in ThisBuild := "com.github.lavenderx"
scalaVersion in ThisBuild := "2.11.8"


lazy val commonSettings = Seq(
  homepage := Some(url("https://github.com/lavenderx/spark-scala-tutorial")),

  developers := List(Developer(
    "lavenderx",
    "Zongzhi Bai",
    "dolphineor@gmail.com",
    url("https://github.com/lavenderx"))
  ),

  scmInfo := Some(ScmInfo(
    url("https://github.com/lavenderx/spark-scala-tutorial"),
    "scm:git:git@github.com:lavenderx/spark-scala-tutorial.git")
  ),

  licenses := Seq(
    ("MIT", url("https://opensource.org/licenses/MIT"))
  ),

  name := "spark-scala-tutorial",

  version := "1.0-SNAPSHOT",

  fork in run := true,

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation"
  ),

  javacOptions in compile ++= Seq(
    "-encoding", "UTF-8",
    "-source", "1.8",
    "-target", "1.8",
    "-Xlint:unchecked",
    "-Xlint:deprecation"
  ),

  ivyScala := ivyScala.value map {
    _.copy(overrideScalaVersion = true)
  },

  resolvers ++= Seq(
    "repox" at "http://repox.gtan.com:8078/"
  ),

  libraryDependencies ++= {
    val akkaVersion = "2.3.11"
    val sparkVersion = "2.0.0"
    Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion,
      "org.apache.spark" %% "spark-sql" % sparkVersion,
      "org.apache.spark" %% "spark-streaming" % sparkVersion,
      "org.apache.spark" %% "spark-graphx" % sparkVersion,
      "org.apache.spark" %% "spark-mllib" % sparkVersion,
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "org.scalatest" %% "scalatest" % "2.2.6" % "test"
    )
  },

  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)
)

lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings: _*)
