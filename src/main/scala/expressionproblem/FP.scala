package cl.uchile.dcc
package expressionproblem

// En este enfoque, usamos funciones separadas (eval y stringify) para operar sobre las expresiones. Cada tipo de 
// expresión es una clase de datos simple y las operaciones se definen utilizando patrones de coincidencia (match). Este
// enfoque es bueno para agregar nuevas operaciones, pero agregar nuevos tipos de datos requiere modificar todas las
// funciones de operaciones existentes.
object FP {
  sealed trait Exp
  case class Literal(n: Int) extends Exp
  case class Sum(e1: Exp, e2: Exp) extends Exp
  case class Sub(e1: Exp, e2: Exp) extends Exp

  def eval(e: Exp): Int = {
    e match {
      case Literal(n)      => n
      case Sum(e1, e2) => eval(e1) + eval(e2)
      case Sub(e1, e2) => eval(e1) - eval(e2)
    }
  }

  def stringify(e: Exp): String = {
    e match {
      case Literal(n)      => n.toString
      case Sum(e1, e2) => s"(${stringify(e1)} + ${stringify(e2)})"
      case Sub(e1, e2) => s"(${stringify(e1)} - ${stringify(e2)})"
    }
  }

  def main(args: Array[String]): Unit = {
    val e = Sum(Literal(1), Sub(Literal(9), Sum(Literal(3), Literal(2))))
    println(eval(e))
    println(stringify(e))
  }
}
