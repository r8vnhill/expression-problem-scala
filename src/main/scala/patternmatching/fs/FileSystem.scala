package cl.uchile.dcc
package patternmatching.fs

class FileSystem {
  val root: Directory = Directory("root")
  def numberOfFiles: Int = NumberOfFiles(root)
  def numberOfDirectories: Int = NumberOfDirectories(root)
  def listing: String = Listing(root)
}
