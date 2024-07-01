package cl.uchile.dcc
package patternmatching

import scala.util.Random

object CustomerId {
  def apply(name: String): String = s"$name--${Random.nextLong}"

  def unapply(customerId: String): Option[String] = {
    val stringArray: Array[String] = customerId.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}

@main def testCustomerId(): Unit = {
  val customerId = CustomerId("Tom Taylor") // Tom Taylor--1234567890
  customerId match {
    case CustomerId(name) => println(s"Name: $name")  // prints Name: Tom Taylor
    case _ => println("Could not extract a name")
  }
}