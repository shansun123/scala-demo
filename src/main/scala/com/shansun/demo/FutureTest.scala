package com.shansun.demo

import scala.actors._
import scala.actors.Actor._

object FutureTest {
    def main(args: Array[String]) {
        val cq = new ConcurrentQuerier()
        //I don't think the Actor semantics guarantee that the result is absolutely, positively the first to have posted the "COMPLETED" message
        println("Among the first to finish was : " + cq.synchronousQuery)
    }
    
    //Top-level class that wants to return the first-completed result from some long-running actors
    class ConcurrentQuerier() {
        //Synchronous function; perhaps fulfilling some legacy interface
        def synchronousQuery: String = {
            val start = System.currentTimeMillis()
            
            //Instantiate and start the monitoring Actor
            val progressReporter = new ProgressReporter(self) //All (?) objects are Actors 
            progressReporter.start()

            //Instantiate the long-running Actors, giving each a handle to the monitor
            val lrfs = List(
                new LongRunningFunction(0, 2000, progressReporter), new LongRunningFunction(1, 2000, progressReporter), new LongRunningFunction(2, 2000, progressReporter),
                new LongRunningFunction(3, 2000, progressReporter), new LongRunningFunction(4, 2000, progressReporter), new LongRunningFunction(5, 2000, progressReporter))

            //Start 'em
            lrfs.map { lrf =>
                lrf.start()
            }
            println("All actors started...")

            /* 
            This blocks until it receives a String in the Inbox.
            Who sends the string? A: the progressReporter, which is monitoring the LongRunningFunctions
            */ 
            
            for(i <- 0 until 6) {
                receive {
	                case s: String => println("Received " + s + " after " + (System.currentTimeMillis() - start) + " ms")
	            }
            } 
            
            println("Finished all after " + (System.currentTimeMillis() - start) + " ms")
            
            "skipped."
        }
    }

    /* 
    An Actor that reacts to a message that is a tuple ("COMPLETED", someResult) and sends the
    result to this Actor's owner. Not strictly necessary (the LongRunningFunctions could post
    directly to the owner's mailbox), but I like the idea that monitoring is important enough
    to deserve its own object
*/
    class ProgressReporter(val owner: Actor) extends Actor {
        def act() = {
        	while(true) {
	            println("progressReporter awaiting news...")
	            receive {
	                case ("COMPLETED", s) =>
	                    println("progressReporter received a completed signal " + s);
	                    owner ! s
	                case s =>
	                    println("Unexpected message: " + s); act()
	            }
        	}
        }
    }

    /*
    Some long running function
*/

    class LongRunningFunction(val id: Int, val timeout: Int, val supervisor: Actor) extends Actor {
        def act() = {
            //Do the long-running query
            val s = longRunningQuery()
            println(id.toString + " finished, sending results")
            //Send the results back to the monitoring Actor (the progressReporter)
            supervisor ! ("COMPLETED", s)
        }

        def longRunningQuery(): String = {
            println("Starting Agent " + id + " with timeout " + timeout)
            Thread.sleep(timeout)
            "Query result from agent " + id
        }
    }
}
