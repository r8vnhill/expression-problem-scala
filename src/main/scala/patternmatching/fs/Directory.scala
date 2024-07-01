package cl.uchile.dcc
package patternmatching.fs

class Directory(name: String) extends Item {
  override def getName: String = name

  override def getSize: Int = ???
  
  def contents: List[Item] = ???
}
