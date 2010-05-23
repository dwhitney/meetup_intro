import scala.io.Source
import scala.xml.XML
import java.net.URL

trait Rest{
    
    def GET(url: String): String = Source.fromURL(new URL(url)).getLines().mkString

}

trait Twitter extends Rest{
    
    val statusUrl = "http://api.twitter.com/1/users/show.xml?screen_name="
    
    def getStatus(username: String): String = {
        val xml = XML.load(GET(statusUrl + username))
        (xml \ "status" \ "text").text
    }
    
}