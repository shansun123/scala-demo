/**
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-22
 */
package com.shansun {
	import akka.actor.ActorSystem
	
	package object demo {
		val system = ActorSystem("MySystem")
	}
}