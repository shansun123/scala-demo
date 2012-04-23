package com.shansun.demo

/**
 * <p></p>
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-10
 */
object EnumerationTest {
	import com.shansun.demo.WeekDay._
	
    def testEnum() = {
    	def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)  
	  
    	WeekDay.values filter isWorkingDay foreach println
    	
//	    WeekDay filter isWorkingDay foreach println  
    }
	
	def main(args: Array[String]) {
		testEnum
	}
}

object WeekDay extends Enumeration {
    type WeekDay = Value
    val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}  
  
  
    