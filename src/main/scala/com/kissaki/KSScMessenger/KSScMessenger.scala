package com.kissaki.KSScMessenger


import akka.actor._
import akka.routing.BroadcastRouter
import java.util.UUID
import scala.collection.mutable.ListBuffer

/*
	version 0.1.0	01/13/13 21:12:27

*/

case class MessengerTrait

trait TimeAssert {
	def timeAssert(timestamp:String, message: String, delay:Int = 0) = {
		
		val delayed = {

			// 01/15/13 10:52:06

			true
		}

		assert(delayed, "BOMB:"+message)
	}
}

trait MessageReceiver extends MessengerTrait {
	def ast = println("hereComes!! trait")
}

class  KSScMessenger (name:String, receiver:String => Unit) extends TimeAssert {
	val myName = name
	val myId = UUID.randomUUID().toString()

	timeAssert("01/15/13 11:03:38", "ログ、用意してみよう http://doc.akka.io/docs/akka/2.0/scala/logging.html")
	val log : ListBuffer[String] = ListBuffer()

	timeAssert("01/15/13 11:03:44", "event bus http://doc.akka.io/docs/akka/2.0/scala/event-bus.html")



	// val childList : ListBuffer[MessengerActor] = ListBuffer() 直にポインタを持たないでもOKな筈！！！
	// val parent : ListBuffer[MessengerActor] = ListBuffer()

	def parentName : String = ""//parent(0).name
	def parentId : String = ""//parent(0).id


	def findParent(targetParentName:String) = {
	  timeAssert("01/15/13 12:05:54", "not yet applied")
	}

	def findParentWithSpecificId(targetParentName:String, specificMessengerId:String) = {
	  timeAssert("01/15/13 12:05:56", "not yet applied")
	}
	
	def injectMyselfToChild(childMessenger:KSScMessenger) = {
		childMessenger.findParentWithSpecificId(myName, myId)
		timeAssert("01/15/13 12:05:58", "not yet applied")
	}
	


	def callMyself(arg: String) = {
		
	}

	def callParent(arg: String) = {
		
	}

	def callChild(arg: String) = {
		
	}
	
	def callback(arg: String) = {
		timeAssert("01/15/13 12:06:08", "クロージャ渡されるのもありかな。")
	}


	val system = ActorSystem("namespace")
	
	println("receiver	"+receiver)
	
	receiver("from Messenger")

	/*
	Booter

	特定のオブジェクトの特定のThreadを叩く。

	そのオブジェクトがtraitを積んでいる事は、どう表現すればいいんだろう。
	→いらん。関数積めばいいや。


	Centralがあれば、そこに向かってつなぐ
	systemの名称が同一なら、そのままでいいような。
	call to system　みたいなのが有ればいいんだよな。

	Broadcastの実験で、Routerを使って複数同じActorを作る事が出来ていた。
	なので、そのへんを応用すれば、Broadcastは実現できる筈。
	*/
	

	system.shutdown

}

class KSScActor() extends Actor {
	println("KSScActor initialize")
	 def receive = {
  	case a => println("hereComes receive	"+a)
  }
}