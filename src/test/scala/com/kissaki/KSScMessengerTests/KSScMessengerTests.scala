package com.kissaki.ksscmessenger.KSScMessengerTests

import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import com.kissaki.KSScMessenger
import com.kissaki.KSScMessenger.KSScMessenger



@RunWith(classOf[JUnitRunner])
class KSScMessengerTests extends Specification {

  val TEST_PARENT_A = "TEST_PARENT_A"
  val TEST_CHILD_A = "TEST_CHILD_A"
  val TEST_CHILD_B = "TEST_CHILD_B"


  /*
	 * テストを書いてく。
	 */
  "test" should {
    "something" in {
      val s = "something"

      //文字列がマッチ
      s must be_==("something")
    }
  }

  /*
  test about relationships.
  */
  "relationship" should {

    class Parent {
      val messenger = new KSScMessenger(TEST_PARENT_A, parentReceiver)
      def parentReceiver(input:String) = {
        // "どんなことで分解するか、っていうと、input = concreteから何かすればいいと思うのだが、はてさて"

        /*
        やりたい事は、
        ・副作用でベキ的に受ける
          caseに発展できればいいよね
        */

      }
    }

    class ChildA {
      val messenger = new KSScMessenger(TEST_CHILD_A, parentReceiver)
      def parentReceiver(input:String) = {}
    }
    
    val parent = new Parent
    val child = new ChildA


    "make parent" in {
      val before = child.messenger.log.size
      
      child.messenger.findParent(TEST_PARENT_A)

      val after = child.messenger.log.size
      after must be_==(before + 1)//1ですむかなあ、、
    }

    "make child" in {
      val after = child.messenger.log.size
      println("after  "+after)
      parent.messenger.injectMyselfToChild(child.messenger)
      "false" must be_==("not yet applied")
    }

    "call child" in {
      "false" must be_==("not yet applied")
    }

    "call multiple child" in {
      "false" must be_==("not yet applied")
    }

    "call parent" in {
      "false" must be_==("not yet applied")
    }

    "callback from parent to child" in {
      child.messenger.callParent("")
      "false" must be_==("not yet applied")
    }

    "callback from parent to multi child" in {
      "false" must be_==("not yet applied, should one child who callParent will be receive callback.")
    }

    "callback from child to parent" in {
      "false" must be_==("not yet applied, should one child who callParent will be receive callback.")
    }




  }



}