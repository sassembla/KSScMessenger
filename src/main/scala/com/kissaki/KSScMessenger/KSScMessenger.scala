package com.kissaki.KSScMessenger


import akka.actor._
import akka.routing.BroadcastRouter
/*
	version 0.1.0	01/13/13 21:12:27


	ラッパーがいらない気がしてるんだよなー。
*/
class  KSScMessenger () {


	val system = ActorSystem("Hoge")
	
	val broadcastRouter = system.actorOf(Props[KSScActor].withRouter(BroadcastRouter(1)), "router")
	broadcastRouter ! "this is a broadcast message"

  system.shutdown

}

class KSScActor() extends Actor {
	println("KSScActor initialize")
	 def receive = {
  	case a => println("hereComes receive	"+a)
  }
}