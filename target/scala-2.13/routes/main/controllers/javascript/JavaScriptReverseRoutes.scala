// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseTransactionController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def balance: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TransactionController.balance",
      """
        function(from0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "balance/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("from", from0))})
        }
      """
    )
  
    // @LINE:1
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TransactionController.add",
      """
        function(from0,amount1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("from", from0)) + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].javascriptUnbind + """)("amount", amount1)])})
        }
      """
    )
  
    // @LINE:3
    def transfer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TransactionController.transfer",
      """
        function(from0,to1,amount2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "transfer/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("from", from0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("to", to1)) + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Option[Int]]].javascriptUnbind + """)("amount", amount2)])})
        }
      """
    )
  
  }


}
