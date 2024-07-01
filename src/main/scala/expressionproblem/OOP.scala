package cl.uchile.dcc
package expressionproblem


object OOP {
  trait Exp {
    def eval: Int

    def print: String
  }

  case class Literal(n: Int) extends Exp {
    def eval: Int = n

    def print: String = n.toString
  }

  case class Sum(e1: Exp, e2: Exp) extends Exp {
    def eval: Int = e1.eval + e2.eval

    def print: String = s"(${e1.print} + ${e2.print})"
  }

  case class Sub(e1: Exp, e2: Exp) extends Exp {
    def eval: Int = e1.eval - e2.eval

    def print: String = s"(${e1.print} - ${e2.print})"
  }

  def main(args: Array[String]): Unit = {
    val e = Sum(Literal(1), Sub(Literal(9), Sum(Literal(3), Literal(2))))
    println(e.eval)
    println(e.print)
  }
}
