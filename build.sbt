name := "scala-demo"

version := "1.0"

scalaVersion := "2.9.2"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "Local Maven Repository" at "file:///D:/tb-repo/"

resolvers += "Taobao Repository" at "http://mvnrepo.taobao.ali.com/mvn/repository/"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8" % "test->default",
  "org.apache.zookeeper" % "zookeeper" % "3.4.3" withSources() excludeAll(
	    ExclusionRule(organization = "com.sun.jdmk"),
	    ExclusionRule(organization = "com.sun.jmx"),
	    ExclusionRule(organization = "javax.jms")
   ),
  "com.typesafe.akka" % "akka-actor" % "2.0" exclude("org.scala-lang", "scala-library")
)

// Make project encoded in GBK by default
scalacOptions ++= Seq("-encoding", "GBK")