import sbt._

class IntroProject(info: ProjectInfo) extends DefaultProject(info){
    
    val scalatest = "org.scalatest" % "scalatest" % "1.2-for-scala-2.8.0.RC2-SNAPSHOT"
    val scalaToolsSnapshots = "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"
    
}