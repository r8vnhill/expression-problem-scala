package cl.uchile.dcc
package patternmatching.fs

object Listing {
  def apply(item: Item): String = item match {
    case file: File => file.getName
    case directory: Directory => 
      directory.getName + "\n" + directory.contents.map(Listing(_)).mkString("\n")
  }
}
