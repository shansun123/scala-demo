package com.shansun.demo

/**
 * <p></p>
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-22
 */
object ByNameParameter {

    val assertIsEnabled = false

    def boolAssert(precidate: Boolean) = {
        if (assertIsEnabled && !precidate) throw new AssertionError
    }

    def byNameAssert(predicate: => Boolean) = {
        if (assertIsEnabled && !predicate) throw new AssertionError
    }

    def main(args: Array[String]): Unit = {
        val x = 100
        /*
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         */
        // boolAssert(x / 0 == 0)
        
        /*
         * OK
         */
        byNameAssert(x / 0 == 0)
    }

}