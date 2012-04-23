package com.shansun.demo

import java.lang.Math._

/**
 * <p></p>
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-13
 */
object FunctionCurryingDemo {

    def curry[A, B, C](func: (A, B) => C): A => B => C = a => b => func(a, b)

    def main(args: Array[String]): Unit = {
        val c = Circle(Point(3, 5), 20)

        println(radius(c))

        println(isWithin(c, Point(2, 6)))

        println(isWithin2(c)(Point(4, 7)))

        println(isWithin2(c)(Point(10, 39)))

        val observes: Point => Boolean = isWithin2(c)

        println(observes(Point(10, 20)))

        val curriedIsWithin: Circle => Point => Boolean = curry(isWithin)
        
        println(curriedIsWithin(c)(Point(20, 3)))
        
        val curriedIsWithin2 : Circle => Point => Boolean = isWithin.curried
        
        println(curriedIsWithin2(c)(Point(14, 15)))
    }

    val radius: Circle => Int = {
        circle =>
            {
                val Circle(center, rad) = circle
                rad
            }
    }

    val center: Circle => Point = {
        circle =>
            {
                val Circle(center, _) = circle
                center
            }
    }

    val isWithin: (Circle, Point) => Boolean = {
        (circle, point) =>
            {
                val Point(a, b) = center(circle)
                val Point(x, y) = point
                pow(x - a, 2) + pow(y - b, 2) <= pow(radius(circle), 2)
            }
    }

    val isWithin2: Circle => (Point => Boolean) = {
        circle =>
            {
                val radSquare = pow(radius(circle), 2)
                val Point(a, b) = center(circle)

                point => {
                    val Point(x, y) = point

                    pow(x - a, 2) + pow(y - b, 2) <= radSquare
                }
            }
    }
}

case class Point(val x: Int, val y: Int)

case class Circle(val p: Point, val radius: Int)