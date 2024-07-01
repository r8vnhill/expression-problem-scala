package cl.uchile.dcc
package expressionproblem

// En este enfoque, usamos traits y clases para definir expresiones y sus operaciones. Cada nueva operación (como eval y
// stringify) se agrega implementando métodos en las clases de datos (Lit, Sum, Sub). Este enfoque es bueno para agregar
// nuevos tipos de datos, pero agregar nuevas operaciones requiere modificar todas las clases de datos existentes.
object OOP {
  trait Exp {
    def eval: Int

    def stringify: String
  }

  case class Literal(n: Int) extends Exp {
    def eval: Int = n

    def stringify: String = n.toString
  }

  case class Sum(e1: Exp, e2: Exp) extends Exp {
    def eval: Int = e1.eval + e2.eval

    def stringify: String = s"(${e1.stringify} + ${e2.stringify})"
  }

  case class Sub(e1: Exp, e2: Exp) extends Exp {
    def eval: Int = e1.eval - e2.eval

    def stringify: String = s"(${e1.stringify} - ${e2.stringify})"
  }

  def main(args: Array[String]): Unit = {
    val e = Sum(Literal(1), Sub(Literal(9), Sum(Literal(3), Literal(2))))
    println(e.eval)
    println(e.stringify)
  }
}
