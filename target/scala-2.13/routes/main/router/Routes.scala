// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  TransactionController_0: controllers.TransactionController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    TransactionController_0: controllers.TransactionController
  ) = this(errorHandler, TransactionController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TransactionController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add/""" + "$" + """from<[^/]+>""", """controllers.TransactionController.add(from:String, amount:Option[Int])"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """balance/""" + "$" + """from<[^/]+>""", """controllers.TransactionController.balance(from:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """transfer/""" + "$" + """from<[^/]+>/""" + "$" + """to<[^/]+>""", """controllers.TransactionController.transfer(from:String, to:String, amount:Option[Int])"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_TransactionController_add0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add/"), DynamicPart("from", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TransactionController_add0_invoker = createInvoker(
    TransactionController_0.add(fakeValue[String], fakeValue[Option[Int]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TransactionController",
      "add",
      Seq(classOf[String], classOf[Option[Int]]),
      "GET",
      this.prefix + """add/""" + "$" + """from<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val controllers_TransactionController_balance1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("balance/"), DynamicPart("from", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TransactionController_balance1_invoker = createInvoker(
    TransactionController_0.balance(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TransactionController",
      "balance",
      Seq(classOf[String]),
      "GET",
      this.prefix + """balance/""" + "$" + """from<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_TransactionController_transfer2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("transfer/"), DynamicPart("from", """[^/]+""",true), StaticPart("/"), DynamicPart("to", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TransactionController_transfer2_invoker = createInvoker(
    TransactionController_0.transfer(fakeValue[String], fakeValue[String], fakeValue[Option[Int]]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TransactionController",
      "transfer",
      Seq(classOf[String], classOf[String], classOf[Option[Int]]),
      "GET",
      this.prefix + """transfer/""" + "$" + """from<[^/]+>/""" + "$" + """to<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_TransactionController_add0_route(params@_) =>
      call(params.fromPath[String]("from", None), params.fromQuery[Option[Int]]("amount", None)) { (from, amount) =>
        controllers_TransactionController_add0_invoker.call(TransactionController_0.add(from, amount))
      }
  
    // @LINE:2
    case controllers_TransactionController_balance1_route(params@_) =>
      call(params.fromPath[String]("from", None)) { (from) =>
        controllers_TransactionController_balance1_invoker.call(TransactionController_0.balance(from))
      }
  
    // @LINE:3
    case controllers_TransactionController_transfer2_route(params@_) =>
      call(params.fromPath[String]("from", None), params.fromPath[String]("to", None), params.fromQuery[Option[Int]]("amount", None)) { (from, to, amount) =>
        controllers_TransactionController_transfer2_invoker.call(TransactionController_0.transfer(from, to, amount))
      }
  }
}
