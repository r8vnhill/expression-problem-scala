package cl.uchile.dcc
package expressionproblem

object EPOneSolution {
  trait Exp {
    def eval: Int
  }

  trait Lit extends Exp {
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

  trait StringifyLiteral extends Lit with StringifyExp {
    def stringify: String = n.toString
  }

  trait PrintSum extends Sum with StringifyExp {
    val e1: StringifyExp
    val e2: StringifyExp

    def stringify = s"(${e1.stringify} + ${e2.stringify})"
  }

  trait PrintSub extends Sub with StringifyExp {
    val e1: StringifyExp
    val e2: StringifyExp

    def stringify = s"(${e1.stringify} - ${e2.stringify})"
  }

  trait CountExp extends Exp {
    def count: Int
  }

  trait CountLit extends Lit with CountExp {
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

  trait CountStringifyLiteral extends CountLit with StringifyLiteral with CountStringifyExpr

  trait CountStringifySum extends CountSum with PrintSum with CountStringifyExpr {
    val e1: CountStringifyExpr
    val e2: CountStringifyExpr
  }

  trait CountStringifySub extends CountSub with PrintSub with CountStringifyExpr {
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
