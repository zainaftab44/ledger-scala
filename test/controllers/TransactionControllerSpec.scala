package controllers

import org.scalatest.Matchers.include
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.libs.ws.{WSClient, WSRequest, WSResponse}
import play.api.test.Helpers._
import org.scalatest.words._
import play.api.libs.json.Json
import play.api.mvc.Results

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
    // await is from play.api.test.FutureAwaits
    for (i <- 0 to 10) {
      val rand = Random.nextLong(500).toInt
      val j = i % names.length
      checkRequest(s"$base_url$path_add${names(j)}?amount=$rand", "POST", "Deposit successful")
    }
  }

  "transfer balance between user accounts" in {
    // await is from play.api.test.FutureAwaits
    for (i <- 0 to 10) {
      val rand = Random.nextLong(300).toInt
      val j = i % names.length
      checkRequest(s"$base_url$path_transfer${names(j)}/${names((j+1)%names.length)}?amount=$rand", "POST", "has transferred")
    }
  }
  "get balance of users" in {
    // await is from play.api.test.FutureAwaits
    for (i <- 0 to 10) {
      val rand = Random.nextLong(500).toInt % names.length
      checkRequest(base_url + path_balance + names(rand), "GET", s"${names(rand)} has balance")
    }
  }

  /**
   * To test the request
   *
   * @param url
   * @param method
   * @param testString
   */
  def checkRequest(url: String, method: String, testString: String): Unit = {
    val wsClient = app.injector.instanceOf[WSClient]
    val response = await(wsClient.url(url).execute(method))
    response.body must include(testString)
    assert(response.body.contains(testString))
  }
}
