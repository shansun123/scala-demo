package com.shansun.demo 

/**
 * http://www.gtan.com/job03.html
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-17
 */
object GtanTest{

    def main(args: Array[String]) {
    	testIncrease
    }
    
    def testIncrease() = {
        assert(increase("R2D3") == "R2D4")
    	assert(increase("R2D9") == "R2E0")
        assert(increase("A99") == "B00")
        assert(increase("Z99") == "AA00")
        assert(increase("Zz99") == "AAa00")
        assert(increase("9Z") == "10A")
    }
    
    val digitals = '0' to '9' toList
    val uppers = 'A' to 'Z' toList
    val lowers = 'a' to 'z' toList

    def next(ch: Char, arr: List[Char]) = {
        val ind = arr.indexOf(ch)
        if (ind == arr.length - 1) (arr(0), true) else (arr(ind + 1), false)
    }

    def next(ch: Char): (Char, Boolean) = {
        if (digitals.contains(ch)) next(ch, digitals)

        else if (uppers contains ch) next(ch, uppers)

        else if (lowers contains ch) next(ch, lowers)

        else throw new IllegalArgumentException
    }
     
    def increase(src: String): String = {
        if (src == "" || src == null) ""

        else {
            val res = src.reverse.foldLeft((List.empty[Char], true))(
                (result, c) => {
                    if (result._2) {
                        val n = next(c)
                        (n._1 :: result._1, n._2)
                    } else {
                        (c :: result._1, false)
                    }
                })

            val newRes: List[Char] = if (res._2) {
                if (digitals.contains(src(0))) '1' :: res._1

                else if (uppers.contains(src(0))) 'A' :: res._1

                else if (lowers.contains(src(0))) 'a' :: res._1
                
                else throw new IllegalAccessError
            } else res._1

            newRes.mkString
        }
    }
}