sealed trait IntList[Size <: IntType] {
  def ::(head:Int):IntList[IntN[Size]] =
    IntListImpl(head, this)
  def +(that:IntList[Size]):IntList[Size]
}