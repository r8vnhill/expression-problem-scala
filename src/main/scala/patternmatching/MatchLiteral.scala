package cl.uchile.dcc
package patternmatching

import scala.util.Random

val x = Random.nextInt(10)

@main def matchTest(): Unit = x match {
  case 1 => println("one")
  case 2 => println("two")
  case 3 => println("three")
  case _ => println("other")
}
