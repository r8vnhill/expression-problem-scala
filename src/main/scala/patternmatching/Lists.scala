package cl.uchile.dcc
package patternmatching

def sumOfInts(list: List[Int]): Int = list match {
  case Nil => 0
  case x :: xs => x + sumOfInts(xs)
}

@main def testSumOfInts(): Unit = {
  val numbers = List(1, 2, 3, 4, 5)
  println(sumOfInts(numbers))
  // prints 15
}