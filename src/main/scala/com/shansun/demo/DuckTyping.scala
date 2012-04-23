package com.shansun.demo

/**
 * <p></p>
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-20
 */
object DuckTyping {

    class Duck {
        def quack = "��..��.."
    }

    object Usage1 {
        def doQuack(d: { def quack: String }) {
            println(d.quack)
        }
    }

    object Usage2 {
        type DuckLike = {
            def quack: String
        }

        def doQuack(d: DuckLike) {
            println(d.quack)
        }

        // �е��� Go���Եĸо�
    }

    def main(args: Array[String]) {
        Usage1.doQuack(new Duck)

        Usage2.doQuack(new Duck)
    }
}