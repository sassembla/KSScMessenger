package com.kissaki.ksscmessenger.KSScMessengerTests

import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith
import com.kissaki.KSScMessenger
import com.kissaki.KSScMessenger.KSScMessenger



@RunWith(classOf[JUnitRunner])
class KSScMessengerTests extends Specification {

  /*
  test about relationships.
  */
  "relationship" should {
    
    val TEST_PARENT = "01/15/13 21:44:20"

    class Parent {
      val messenger = new KSScMessenger(TEST_PARENT, parentReceiver)
      def parentReceiver(input:String) = {
        // "どんなことで分解するか、っていうと、input = concreteから何かすればいいと思うのだが、はてさて"

        /*
        やりたい事は、
        ・副作用でベキ的に受ける
          caseに発展できればいいよね
        */

      }
    }

    val TEST_CHILD_A = "01/15/13 21:44:20"
    val TEST_CHILD_B = "01/16/13 00:36:38"
    
    class ChildA {
      val messenger = new KSScMessenger(TEST_CHILD_A, childReceiver)
      def childReceiver(input:String) = {}
    }
    
    class ChildB {
      val messenger = new KSScMessenger(TEST_CHILD_B, childReceiver)
      def childReceiver(input:String) = {}
    }

    val parent = new Parent
    val childA = new ChildA
    val childB = new ChildB


    "make parent" in {
      val before = childA.messenger.log.size
      
      childA.messenger.findParent(TEST_PARENT)

      val after = childA.messenger.log.size
      after must be_==(before + 1)//1ですむかなあ、、
    }

    "make child" in {
      val after = childA.messenger.log.size
      println("after  "+after)
      parent.messenger.injectMyselfToChild(childA.messenger)
      "false" must be_==("not yet applied")
    }

    "remove child" in {
      "false" must be_==("not yet applied")
    }
    "remove from parent" in {
      "false" must be_==("not yet applied")
    }
  }

  "call myself" should {
    val TEST_MYSELF = "01/16/13 00:37:25"

    class Myself {
      val messenger = new KSScMessenger(TEST_MYSELF, myselfReceiver)
      def myselfReceiver(input:String) = {
        // "どんなことで分解するか、っていうと、input = concreteから何かすればいいと思うのだが、はてさて"

        /*
        やりたい事は、
        ・副作用でベキ的に受ける
          caseに発展できればいいよね
        */

      }
    }
    val myself = new Myself
    "call myself" in {
      "false" must be_==("not yet applied")
    }

    "call myself with nest 1" in {
      "false" must be_==("not yet applied")
    }

    "call myself with nest 2" in {
      "false" must be_==("not yet applied")
    }

    "call myself with nest 5" in {
      "false" must be_==("not yet applied")
    }
  }
 
  "call child" should {
    val TEST_PARENT = "01/16/13 00:37:58"

    class Parent {
      val messenger = new KSScMessenger(TEST_PARENT, parentReceiver)
      def parentReceiver(input:String) = {
        
      }
    }

    val TEST_CHILD_A = "01/16/13 00:38:47"

    class ChildA {
      val messenger = new KSScMessenger(TEST_CHILD_A, parentReceiver)
      def parentReceiver(input:String) = {}
    }
    
    val parent = new Parent
    val childA = new ChildA
    
    childA.messenger.findParent(TEST_PARENT)


    "call child" in {
      "false" must be_==("not yet applied")
    }

    "parent called from child" in {
      "false" must be_==("not yet applied") 
    }
  }

  "call child same name" should {
    val TEST_PARENT = "01/16/13 00:39:13"

    class Parent {
      val messenger = new KSScMessenger(TEST_PARENT, parentReceiver)
      def parentReceiver(input:String) = {
        
      }
    }

    val TEST_CHILD_A = "01/16/13 00:39:30"

    class ChildA {
      val messenger = new KSScMessenger(TEST_CHILD_A, parentReceiver)
      def parentReceiver(input:String) = {}
    }
    
    val parent = new Parent
    val child_1 = new ChildA
    val child_2 = new ChildA
    val child_3 = new ChildA
    
    child_1.messenger.findParent(TEST_PARENT)
    child_2.messenger.findParent(TEST_PARENT)
    //_3 is not child of parent

    "call children" in {
      "false" must be_==("not yet applied")
    }

    "call children and _3 will not receive" in {
      "false" must be_==("not yet applied")
    }

    "parent called from child" in {
      "false" must be_==("not yet applied") 
    }
  }

  "call parent" should {
    val TEST_PARENT = "01/16/13 00:40:01"
    
    class Parent {
      val messenger = new KSScMessenger(TEST_PARENT, parentReceiver)
      def parentReceiver(input:String) = {
        

      }
    }

    val TEST_CHILD_A = "01/16/13 00:40:21"

    class ChildA {
      val messenger = new KSScMessenger(TEST_CHILD_A, parentReceiver)
      def parentReceiver(input:String) = {}
    }
    
    val parent = new Parent
    val child = new ChildA

    child.messenger.findParent(TEST_PARENT)

    "call parent" in {
      "false" must be_==("not yet applied")
    }

    "parent called from child" in {
      "false" must be_==("not yet applied") 
    }
  }

  "callback" should {
    val TEST_PARENT = "01/16/13 00:40:38"

    class Parent {
      val messenger = new KSScMessenger(TEST_PARENT, parentReceiver)
      def parentReceiver(input:String) = {
        

      }
    }

    val TEST_CHILD_A = "01/16/13 00:40:54"

    class ChildA {
      val messenger = new KSScMessenger(TEST_CHILD_A, parentReceiver)
      def parentReceiver(input:String) = {}
    }
    
    val parent = new Parent
    val child = new ChildA

    child.messenger.findParent(TEST_PARENT)

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