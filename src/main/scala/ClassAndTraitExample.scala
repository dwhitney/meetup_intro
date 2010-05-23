import scala.io.Source
import scala.xml.XML
import scala.xml.Elem
import java.net.URL

class User(val screenName: String, val name: String, val location: String)
        

class TwitterUser(screenName: String) extends User(screenName, null, null) with TwitterService{
        
    private val cachedName = getName
    private val cachedLocation = getLocation
    
    override val name = cachedName
    override val location = cachedLocation
    
}

object RESTful{   
    def GET(url: String): String = Source.fromURL(new URL(url)).getLines().mkString
}

trait TwitterService{ self: User =>
    
    def xml: Elem = XML.loadString(RESTful.GET("http://api.twitter.com/1/users/show.xml?screen_name=" + screenName))
    
    def getStatus: String = (xml \ "status" \ "text").text
    
    def getName: String = (xml \ "name").text
    
    def getLocation: String = (xml \ "location").text
    
}