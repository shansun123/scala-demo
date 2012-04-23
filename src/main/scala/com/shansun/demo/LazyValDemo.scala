package com.shansun.demo

/**
 * 决岳柴麻
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-22
 */
object LazyValDemo {

    object Demo {
        lazy val x = {
            println("Initializing x..")
            "Done"
        }
    }
    
    def main(args: Array[String]): Unit = {
        println(Demo)
        
        println("！！！！！！！！！！！！！！！！！！！！！！！！！！")
        
        println(Demo.x)
    }

}