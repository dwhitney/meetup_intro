//probably type most of this stuff into the REPL - just here for examples
object ListOperations{

    def main(args: Array[String]){

        println(List("Hello","World","!"))
        
        val integers = List(1, 2, 3, 4, 5)
        val words = List("the", "quick", "brown", "fox", "jumps")
        
        ///////////////////////////////////////////////////////////////////////
        //5. Functions
        //e. map, filter, partition, find
        integers map (_ + 1)
        words map (_.length)
        words map (_ + 1)
        words map (_.toList)
        words flatMap(_.toList)
        integers
        words
        
        integers filter (_ % 2 == 0)
        integers partition (_ % 2 == 0)
        
        integers find (_ % 2 == 0)
        integers find (_ < 0)
        
        ///////////////////////////////////////////////////////////////////////
        //5. Functions
        //f. for, yield
        
        for (word <- words) println(word)
        for (word <- words) yield word
        words == (for (word <- words) yield word)
        
        for (integer <- integers; if integer % 2 == 0) println(integer)
        for (integer <- integers; if integer % 2 == 0) yield integer

        for (integer <- integers; word <- words) println(integer, word)
        
        case class Person(name: String,
                          age: Int,
                          children: Person*)
        val mark = Person("Mark", 19)
        val lisa = Person("Lisa", 22)
        val alex = Person("Alex", 54, mark, lisa)
        val persons = List(mark, lisa, alex)
        
        // how to get list of parent, child pairs?
        persons filter (p => p.age > 30)
        persons filter (p => p.age > 30) flatMap (p => p.children)
        persons filter (p => p.age > 30) flatMap (p => 
                                        (p.children map (c => (p.name, c.name))))
        
        for (p <- persons; if p.age > 30; c <- p.children) yield (p.name, c.name)
        
        ///////////////////////////////////////////////////////////////////////
        //5. Functions
        //g. folding
    
        val abc = List("a", "b", "c")

        ("z" /: abc) (_ + " " + _) 
        // res: java.lang.String = z a b c
        // left-leaning tree
        //               op 
        //             /   \ 
        //            op    c
        //          /   \
        //         op    b 
        //       /   \
        //      z     a
                
        (abc :\ "z") (_ + " " + _)
        // res: java.lang.String = a b c z
        // right-leaning tree
        //               op 
        //             /   \ 
        //            a     op
        //                /   \
        //               b    op 
        //                  /   \
        //                 c     z
        
        (0 /: integers) (_ + _)
        (integers :\ 0) (_ + _)
        //res: Int = 15
        
        integers
        (0 /: integers.tail) (_ + _)
    }
}
