package controllers

import play.api.db._
import play.api.mvc.{AbstractController, ControllerComponents}
import play.api.db.Database
import javax.inject.Inject
import scala.concurrent.Future

class TransactionController @Inject() (db: Database,cc: ControllerComponents) extends AbstractController(cc) {

  def balance(id: String) = Action {
    request => {
      val conn = db.getConnection()
      val stmt = conn.createStatement()

      Ok(id + " has balance [" + db.dataSource + "] ==== ")
    }
  }

  def transfer(from: String, to: String, amount: Option[Int]) = Action {
    request => Ok(from + " has transferred amount [" + amount.get + "] to " + to)
  }

  def add(id: String, amount: Option[Int]) = Action {
    request => Ok(id + " deposited amount [" + amount.get + "]")
  }

}
