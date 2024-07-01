package cl.uchile.dcc
package expressionproblem

// En este enfoque, utilizamos traits y herencia múltiple para combinar diferentes operaciones (evaluación,
// representación, conteo). Este enfoque permite agregar nuevas operaciones sin modificar las clases de datos existentes
// y agregar nuevos tipos de datos sin modificar las operaciones existentes. Sin embargo, puede ser más complejo debido
// a la necesidad de gestionar la herencia múltiple.
object EPOneSolution {
  trait Exp {
    def eval: Int
  }

  trait Literal extends Exp {
    val n: Int

    def eval: Int = n
  }

  trait Sum extends Exp {
    val e1: Exp
    val e2: Exp

    override def eval: Int = e1.eval + e2.eval
  }

  trait Sub extends Exp {
    val e1: Exp
    val e2: Exp

    override def eval: Int = e1.eval - e2.eval
  }

  trait StringifyExp extends Exp {
    def stringify: String
  }

  trait StringifyLiteral extends Literal with StringifyExp {
    def stringify: String = n.toString
  }

  trait StringifySum extends Sum with StringifyExp {
    val e1: StringifyExp
    val e2: StringifyExp

    def stringify = s"(${e1.stringify} + ${e2.stringify})"
  }

  trait StringifySub extends Sub with StringifyExp {
    val e1: StringifyExp
    val e2: StringifyExp

    def stringify = s"(${e1.stringify} - ${e2.stringify})"
  }

  trait CountExp extends Exp {
    def count: Int
  }

  trait CountLiteral extends Literal with CountExp {
    def count = 1
  }

  trait CountSum extends Sum with CountExp {
    val e1: CountExp
    val e2: CountExp

    def count: Int = e1.count + e2.count
  }

  trait CountSub extends Sub with CountExp {
    val e1: CountExp
    val e2: CountExp

    def count: Int = e1.count + e2.count
  }

  trait CountStringifyExpr extends CountExp with StringifyExp

  trait CountStringifyLiteral extends CountLiteral with StringifyLiteral with CountStringifyExpr

  trait CountStringifySum extends CountSum with StringifySum with CountStringifyExpr {
    val e1: CountStringifyExpr
    val e2: CountStringifyExpr
  }

  trait CountStringifySub extends CountSub with StringifySub with CountStringifyExpr {
    val e1: CountStringifyExpr
    val e2: CountStringifyExpr
  }

  def main(args: Array[String]): Unit = {
    val x = new CountStringifyLiteral {
      val n = 1
    }
    val s: CountStringifySum = new CountStringifySum {
      val e1: CountStringifyLiteral = x
      val e2: CountStringifyLiteral = new CountStringifyLiteral {
        val n = 3
      }
    }
    println(s.eval)
    println(s.count)
    println(s.stringify)
  }
}
