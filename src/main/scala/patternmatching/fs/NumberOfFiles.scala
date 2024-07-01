package cl.uchile.dcc
package patternmatching.fs

object NumberOfFiles {
  def apply(item: Item): Int = item match {
    case file: File => 1
    case directory: Directory => 
      directory.contents.map(NumberOfFiles(_)).sum
  }
}
