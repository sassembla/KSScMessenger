package com.kissaki.ksscmessenger.KSScMessenger

import org.specs2.mutable._
import org.specs2.runner.JUnitRunner
import org.junit.runner.RunWith

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



}