import scala.io.Source
import scala.xml.XML
import scala.xml.Elem
import java.net.URL

//should show constructor and alternative constructors
class User(val screenName: String, val name: String, val location: String)
        

class TwitterUser(screenName: String) extends User(screenName, null, null) with TwitterService{
        
    private val cachedName = getName(screenName)
    private val cachedLocation = getLocation(screenName)
    
    override val name = cachedName
    override val location = cachedLocation
    
}

object RESTful{   
    def GET(url: String): String = Source.fromURL(new URL(url)).getLines().mkString
}


//refactor to show self type
trait TwitterService{
    
    def xml(screenName: String): Elem = XML.loadString(RESTful.GET("http://api.twitter.com/1/users/show.xml?screen_name=" + screenName))
    
    def getStatus(screenName: String): String = (xml(screenName) \ "status" \ "text").text
    
    def getName(screenName: String): String = (xml(screenName) \ "name").text
    
    def getLocation(screenName: String): String = (xml(screenName) \ "location").text
    
}