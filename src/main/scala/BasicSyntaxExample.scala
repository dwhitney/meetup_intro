package foo{
    //probably type most of this stuff into the REPL - just here for examples
    object BasicSyntaxExample{

        def main(args: Array[String]){
    
            println("Hello, World!")
    
            //immutable variable
            val i: Int = 0
    
            //immutable variable - show type inference
            val i2 = 0; //semicolon optional
    
            //var - reassignment
            var s: String = "Hello, World"
            s = "Goodbye, World!"
    
            //everything is an object
            val x = 1 + 2
            val x2 = 1.+(2) //mention operator overloading
    
            //imports can be used anywhere
            import java.net.URL
            val url = new URL("http://slashdot.org") //objects created in the same way as java
    
            val myStatus = "This is my status"
            
            val xml = 
                <user>
                    <name>Dustin Whitney</name>
                    <screen_name>dustinwhitney</screen_name>
                    <location>New York, NY</location>
                    <status>
                        <text>{myStatus}</text>
                    </status>
                </user>
        
            val name = (xml \ "name").text
            val status = (xml \ "status" \ "text").text
            
            println(name)
            println(status)
    
            //if returns a value, and the type is inferred
            val what = if(true) 10 else 11
            
            for(i <- 0 until 10){
                println(i)
            }
            
            //don't care about the index
            for(_ <- 0 until 10){
                println("My name is Dustin!")
            }
    
            //show some package stuff
            println(foo.bar.Baz.x)
            println(bar.Baz.x)
            println(_root_.foo.bar.Baz.x)
            
            //showing a package object - don't really plan to talk to much about this - perhaps show a quick example of how 
            //play is using this to make the Java/Scala api look the same
            val myDate = new bar.date.MyDate
            println(myDate.getTime)
            
        }
    }
    
    //showing nesting of packages
    package bar{
        object Baz{
            val x = 10
        }
        
        package object date{
            type MyDate = java.util.Date
        }
    }
}