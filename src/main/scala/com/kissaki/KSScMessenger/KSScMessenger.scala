package com.kissaki.KSScMessenger


import akka.actor._

/*
	version 0.1.0	01/13/13 21:12:27


	ラッパーがいらない気がしてるんだよなー。
*/
class  KSScMessenger () {

	val system = ActorSystem("Hoge")
	val actor = system.actorOf(Props[KSScActor], "KSScActor")


  actor ! "100"

  system.shutdown

}

class KSScActor() extends Actor {
	println("KSScActor initialize")
	 def receive = {
  	case a => println("hereComes receive	"+a)
  }
}