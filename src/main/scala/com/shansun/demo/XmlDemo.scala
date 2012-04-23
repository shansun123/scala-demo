package com.shansun.demo
import java.util.Date

/**
 * <p></p>
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-20
 */
object XmlDemo {

    def main(args: Array[String]): Unit = {
        println(<date>{ new Date }</date>)
    }

}