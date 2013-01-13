package com.kissaki.ksscmessenger.KSScMessengerTests

import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith


import com.kissaki.KSScMessenger


@RunWith(classOf[JUnitRunner])
class KSScMessengerTests extends Specification {

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
  centralがなくせる筈なので、そのへんからやってみるか。
  */
  "message" should {
    "receiveable" in {
      val messenger = new KSScMessenger

      // messenger.callMyself("something")
    }

  }




}