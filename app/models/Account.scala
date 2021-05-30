package models

import play.api.libs.json.{Format, Json}
import anorm.{Macro, ToParameterList}

case class Account(
                    id: Long,
                    name: String,
                    balance: Long
                  )


object Account {
  implicit val format: Format[Account] = Json.format
//  implicit def toParameters: ToParameterList[Account] =
//    Macro.toParameters[Account]
}
//
//case class Account(id: Long, name: String, balance: Long)
//
//object Account {
//  implicit val accountFormat = Json.format[Account]
//}
