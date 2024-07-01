package cl.uchile.dcc
package patternmatching.fs

object NumberOfDirectories {
  def apply(item: Item): Int = item match {
    case file: File => 0
    case directory: Directory => 
      1 + directory.contents.map(NumberOfDirectories(_)).sum
  }
}
