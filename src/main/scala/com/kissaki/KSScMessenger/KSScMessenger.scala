package com.kissaki.KSScMessenger

import akka.actor._
import akka.routing.BroadcastRouter
import java.util.UUID
import scala.collection.mutable.ListBuffer
import java.text.SimpleDateFormat
import java.util.Date

/*
	version 0.1.0	01/13/13 21:12:27

*/

case class Message(message: String)

case class MessengerTrait

trait TimeAssert {
  val SecUnit = 1000

  def timeAssert(timestamp: String, message: String, delaySec: Int = 0) = {
    val timestampDate = new SimpleDateFormat("MM/dd/yy HH:mm:ss").parse(timestamp)
    val limit = timestampDate.getTime + delaySec * SecUnit

    val currentDate = new Date
    val currentDateTime = currentDate.getTime

    val distance = (limit - currentDateTime)

    assert(0 < distance, "TimeAssert BOMB:" + message + "	/" + distance / SecUnit + "	sec over")
    println("TimeAssert passed:" + message + "	/" + distance / SecUnit + "	sec left")
  }
}

trait MessageReceiver extends MessengerTrait {
  def ast = println("hereComes!! trait")
}

class KSScMessenger(name: String, receiver: String => Unit) extends TimeAssert {
  val myName = name
  val myId = UUID.randomUUID.toString

  // val childList : ListBuffer[MessengerActor] = ListBuffer() 直にポインタを持たないでもOKな筈！！！
  // val parent : ListBuffer[MessengerActor] = ListBuffer()

  def parentName: String = "" //parent(0).name
  def parentId: String = "" //parent(0).id

  def findParent(targetParentName: String, specificMessengerId: String = "") = {
    timeAssert("01/19/13 00:29:22", "not yet applied", 1000)
  }

  def injectMyselfToChild(childMessenger: KSScMessenger) = {
    childMessenger.findParent(myName, myId)
    timeAssert("01/19/13 00:29:30", "not yet applied", 1000)
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
	val logListener = system.actorOf(Props[MyEventListener])
	
  //join network
  val actor = system.actorOf(Props[KSScActor])
  system.eventStream.subscribe(actor, classOf[Message])

  def callAny = system.eventStream.publish(Message("hereComes!!!!"))

  def removeFromNetwork = system.shutdown

	

  callAny
  removeFromNetwork
}

class KSScActor extends Actor with ActorLogging {
  import java.util.UUID

  def receive = {
    case a: Message => {
    	log.debug("received")
    }
  }
}


import akka.event.Logging.InitializeLogger
import akka.event.Logging.LoggerInitialized
import akka.event.Logging.Error
import akka.event.Logging.Warning
import akka.event.Logging.Info
import akka.event.Logging.Debug
 
class MyEventListener extends Actor {
	println("loggenerated")
  def receive = {
    case InitializeLogger(_)                        ⇒ print("initilaized")
    case Error(cause, logSource, logClass, message) ⇒ print("Err	"+message)
    case Warning(logSource, logClass, message)      ⇒ print("War	"+message)
    case Info(logSource, logClass, message)         ⇒ print("Inf	"+message)
    case Debug(logSource, logClass, message)        ⇒ print("Deb	"+logSource+ logClass+ message)
  }
}