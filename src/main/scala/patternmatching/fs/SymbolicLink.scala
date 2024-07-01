package cl.uchile.dcc
package patternmatching.fs

class SymbolicLink(name: String, val target: Item) extends Item {
  override def getName: String = name

  override def getSize: Int = 0
}
