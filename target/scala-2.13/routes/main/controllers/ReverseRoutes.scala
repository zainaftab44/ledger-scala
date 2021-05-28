// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseTransactionController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def balance(from:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "balance/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("from", from)))
    }
  
    // @LINE:1
    def add(from:String, amount:Option[Int]): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("from", from)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].unbind("amount", amount)))))
    }
  
    // @LINE:3
    def transfer(from:String, to:String, amount:Option[Int]): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "transfer/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("from", from)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("to", to)) + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].unbind("amount", amount)))))
    }
  
  }


}
