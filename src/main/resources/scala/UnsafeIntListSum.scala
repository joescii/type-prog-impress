sealed trait IntList {
  // Convenience list constructor
  def ::(head:Int):IntList = IntListImpl(head, this)
  // Vector addition
  def +(that:IntList):IntList
  def size:Int
}