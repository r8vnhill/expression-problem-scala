package cl.uchile.dcc
package patternmatching.expr

def eval(e: Expr): Int = e match {
  case Literal(v) => v
  case Add(l, r) => eval(l) + eval(r)
  case Sub(l, r) => eval(l) - eval(r)
}
