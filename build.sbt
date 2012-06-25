name := "scala-demo"

version := "1.0"

scalaVersion := "2.9.1"

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
  "com.typesafe.akka" % "akka-actor" % "2.0" exclude("org.scala-lang", "scala-library"),
  "org.scalaquery" %% "scalaquery" % "0.10.0-M1",
  "org.squeryl" %% "squeryl" % "0.9.5",
  "mysql" % "mysql-connector-java" % "5.1.10",
  "org.htmlparser" % "htmlparser" % "1.6"
)


// Make project encoded in GBK by default
scalacOptions ++= Seq("-encoding", "GBK")