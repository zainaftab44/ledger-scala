package controllers

import play.api.mvc.{AbstractController, ControllerComponents, Result}
import play.api.mvc.Results.Ok
import play.mvc.Controller

import javax.inject.Inject
import anorm._

class TransactionController (cc: ControllerComponents) extends AbstractController(cc) {

  def balance(id: String) = Action {
    request => {
      Ok(id + " has balance [" + database + "]")
    }
  }

  def transfer(from: String, to: String, amount: Option[Int]) = Action {
    request => Ok(from + " has transferred amount [" + amount.get + "] to " + to)
  }

  def add(id: String, amount: Option[Int]) = Action {
    request => Ok(id + " deposited amount [" + amount.get + "]")
  }

}
