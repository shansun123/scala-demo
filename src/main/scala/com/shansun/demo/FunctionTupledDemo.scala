package com.shansun.demo

/**
 * Funtion2.tupled������ʾ
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-13
 */
class FunctionTupledDemo {

    def f(i: Int, j: Int) = i + j

    def ft = (f _).tupled

    def main(args: Array[String]): Unit = {
        val tup = (10, 20)

        println(ft(tup))
    }

}