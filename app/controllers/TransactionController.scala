package controllers

import anorm.SqlParser.{get, scalar}
import anorm.{~, _}
import models._
import play.api.db._
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import javax.inject.Inject
import scala.concurrent.Future

class TransactionController @Inject()(database: Database, ec: DatabaseExecutionContext, cc: ControllerComponents) extends AbstractController(cc) {

  def balance(id: String) = Action {
    if (!checkUserExists(id))
      NotFound(Json.obj("message" -> "User does not exist"))
    else
      Ok(Json.obj("message" -> s"$id has balance ${getBalance(id)}"))
  }

  def transfer(from: String, to: String, amount: Option[Long]) = Action {
    if (!checkUserExists(from))
      Ok(Json.obj("message" -> "Sender does not exist"))
    else if (!checkUserExists(to))
      Ok(Json.obj("message" -> "Receiver does not exist"))
    else if (amount.get < 0 || amount.get > getBalance(from))
      Ok(Json.obj("message" -> "Cannot perform transfer: Invalid transfer amount"))
    else
      database.withConnection {
        implicit connection => {
          val rs = SQL("Update Accounts set balance=balance-{amount} where name={name}").onParams(amount, from).executeUpdate()
          var message = "Transfer failed"
          if (rs > 0) {
            val rs = SQL("Update Accounts set balance=balance+{amount} where name={name}").onParams(amount, to).executeUpdate()
            if (rs > 0)
              message = s"$from has transferred ${amount.get} to $to\'s account"
          }
          Ok(Json.obj("message" -> message))
        }
      }
  }

  def add(id: String, amount: Option[Long]) = Action {
    if (!checkUserExists(id))
      Ok(Json.obj("message" -> "User does not exist"))
    else if (amount.get < 0)
      Ok(Json.obj("message" -> "Deposit amount cannot be less than 0"))
    else
      database.withConnection {
        implicit connection => {
          val rs = SQL("Update Accounts set balance=balance+{amount} where name={name}").onParams(amount, id).executeUpdate()
          if (rs == 0)
            NotFound(Json.obj("message" -> "Unable to deposit amount"))
          else
            Ok(Json.obj("message" -> "Deposit successful"))
        }
      }
  }

  def getBalance(name: String): Long = {
    database.withConnection {
      implicit connection => {
        val res: SqlQueryResult = SQL("select balance from Accounts where name={name}").onParams(name).executeQuery()
        val balance = res as scalar[Long].singleOpt;
        return balance.get
      }
    }
  }

  def checkUserExists(name: String): Boolean = {
    database.withConnection {
      implicit connection => {
        val rs = SQL("Select * from Accounts where name={name}").onParams(name).executeQuery()
        val acc = rs as account.singleOpt;
        return !acc.isEmpty
      }
    }
  }


  /**
   * Parse a Account from a ResultSet
   */
  private val account = {
    get[Long]("Accounts.id") ~
      get[String]("Accounts.name") ~
      get[Long]("Accounts.balance") map {
      case id ~ name ~ balance =>
        Account(id, name, balance)
    }
  }

}
