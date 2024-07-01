package cl.uchile.dcc
package patternmatching.fs

object SizeOf {
  def apply(item: Item): Int = item match {
    case file: File => file.getSize
    case directory: Directory =>
      directory.contents.map(SizeOf(_)).sum
    case link: SymbolicLink =>
      SizeOf(link.target)
  }
}
