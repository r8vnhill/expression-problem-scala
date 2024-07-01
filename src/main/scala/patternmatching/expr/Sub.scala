package cl.uchile.dcc
package patternmatching.expr

class Sub(left: Expr, right: Expr) extends Expr {
  override def eval: Int = left.eval - right.eval
}
