name := "specs2-demo"

version := "1.0-SNAPSHOT"

organization := "com.recursivity"

scalaVersion := "2.10.3"


resolvers ++= Seq("Sonatype Nexus releases" at "https://oss.sonatype.org/content/repositories/releases", 
	"Sonatype Nexus snapshots" at "https://oss.sonatype.org/content/repositories/snapshots", "Scala-Tools repo" at "http://scala-tools.org/repo-releases/",
	"object web" at "http://maven.ow2.org/maven2/", "novus" at "http://repo.novus.com/snapshots/")

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2" % "2.3.3" % "test", 
	"org.pegdown" % "pegdown" % "0.9.2" % "test",
	"org.hamcrest" % "hamcrest-all" % "1.3" % "test"
	)

testOptions in Test += Tests.Argument("html")

scalacOptions in Test ++= Seq("-Yrangepos")

logBuffered := false
