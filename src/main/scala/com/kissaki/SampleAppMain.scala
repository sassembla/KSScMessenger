package com.kissaki.KSScMessenger

import com.kissaki.KSScMessenger

object SampleAppMain extends MessageReceiver {

	def mal(input:String) = {
	  println("input = "+input)
	} 
	
	def main(args: Array[String]) = {
		println("hereComes")
		
		val a = new KSScMessenger("", mal)

		ast
	}
}