package cl.uchile.dcc
package patternmatching.expr

def stringify(e: Expr): String = e match {
  case Literal(v) => v.toString
  case Add(l, r) => s"(${stringify(l)} + ${stringify(r)})"
  case Sub(l, r) => s"(${stringify(l)} - ${stringify(r)})"
}
