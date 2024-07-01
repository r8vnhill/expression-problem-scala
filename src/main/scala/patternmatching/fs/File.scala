package cl.uchile.dcc
package patternmatching.fs

class File(name: String) extends Item {
  override def getName: String = name

  override def getSize: Int = 1
}
