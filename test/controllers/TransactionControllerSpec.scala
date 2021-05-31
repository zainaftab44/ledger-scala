package controllers

import org.scalatest.Matchers.include
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.api.test.Helpers._
import org.scalatest.words._
import play.api.libs.json.Json

import scala.language.postfixOps
import scala.util.Random

class ApplicationIntegrationSpec extends PlaySpec with GuiceOneAppPerSuite {
  val port = 9000
  val names: Array[String] = Array("Zain", "Jieren", "A", "B", "user")
  val base_url = s"http://localhost:$port"
  val path_add = s"/add/"
  val path_balance = s"/balance/"
  val path_transfer = s"/transfer/"


  "add balance to user accounts" in {
    val wsClient = app.injector.instanceOf[WSClient]
    // await is from play.api.test.FutureAwaits
    for (i <- 0 to 10) {
      val rand = Random.nextLong(500).toInt
      val j = rand % names.length

//      val response: WSResponse = await(wsClient.url(s"$base_url$path_add${names(j)}?amount=$rand").post(Json.parse()))
//      response.body must include("Deposit successful")
//      assert(response.body.contains("Deposit successful"))
    }
  }

  "get balance of users" in {
    val wsClient = app.injector.instanceOf[WSClient]
    // await is from play.api.test.FutureAwaits
    for (i <- 0 to 10) {
      val rand = Random.nextLong(500).toInt % names.length
      val response = await(wsClient.url(base_url + path_balance + names(rand)).get())
      response.body must include(s"${names(rand)} has balance")
      assert(response.body.contains("has balance"))
    }
  }
}
