import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.3",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "datagen",
    libraryDependencies += "org.yaml" % "snakeyaml" % "1.5",
    libraryDependencies += "com.github.javafaker" % "javafaker" % "0.14",    libraryDependencies += scalaTest % Test
  )
