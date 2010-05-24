//probably type most of this stuff into the REPL - just here for examples
object ListOperations{

    def main(args: Array[String]){

        println(List("Hello","World","!"))
        
        val integers = List(1, 2, 3, 4, 5)
        val words = List("the", "quick", "brown", "fox", "jumps")
        
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
        
        //5. Functions
        //f. for, yield
        
        
        
        
        
        
        
        //5. Functions
        //g. folding
    
        val abc = List("a", "b", "c")

        ("z" /: abc) (_ + " " + _)
        // res: java.lang.String = z a b c
        //               op 
        //             /   \ 
        //            op    c
        //          /   \
        //         op    b 
        //       /   \
        //      z     a        
        (abc :\ "z") (_ + " " + _)
        // res: java.lang.String = a b c z
        //               op 
        //             /   \ 
        //            a     op
        //                /   \
        //               b    op 
        //                  /   \
        //                 c     z
        
        (0 /: integers) (_ + _)
        (integers :\ 0) (_ + _)
        res: Int = 15
        
        
        
    }
}
