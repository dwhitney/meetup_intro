import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers

class ClassAndTraitExampleSpec extends FlatSpec with MustMatchers {

    "A ClassAndTraitExample" must "fetch a status" in {
        
        val user = new TwitterUser("dustinwhitney"){
            override def xml = 
                <user>
                    <name>Dustin Whitney</name>
                    <location>New York City, NY</location>
                    <status>
                        <text>fake status</text>
                    </status>
                </user>
        }
        
        user.getStatus must equal("fake status")
        user.name must equal("Dustin Whitney")
        user.location must equal("New York City, NY")

    }
}
