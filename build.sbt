name := "learning"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies += "com.typesafe.scala-logging" % "scala-logging-slf4j_2.10" % "2.1.2"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.10"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.3.0" % "compile"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.3.0" % "compile"

libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.3.15" % "compile"

classpathTypes += "maven-plugin"

libraryDependencies += "org.bytedeco" % "javacv" % "1.1" % "compile"

libraryDependencies += "org.bytedeco" % "javacpp" % "1.1" % "compile"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"