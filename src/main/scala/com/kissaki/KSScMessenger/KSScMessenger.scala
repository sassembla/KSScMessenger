import akka.actors._




class  KSScMessenger () extends Actor {
  println("ここに来てる")
	val system = ActorSystem("Hoge")
  //val hogeActor = system.actorOf(Props[KSScMessenger])


  // hogeActor ! 100
  // hogeActor ! "taro"

  system.shutdown()

}