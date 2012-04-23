package com.shansun.demo
 
import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorSystem 
import akka.actor.Props

object AkkaTest {

    def main(args: Array[String]) {
    	testActor
    }
    
    def testActor() {
        val greeter = system.actorOf(Props[GreetingActor], name = "greeter")
        greeter ! Greeting("Chris")
    }
}

case class Greeting(who: String)

class GreetingActor extends Actor with ActorLogging {
    def receive = {
        case Greeting(who) => log.info("Hello " + who)
    }
}