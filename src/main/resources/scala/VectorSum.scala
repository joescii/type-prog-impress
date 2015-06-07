sealed trait Vector[Size <: IntType] {
  def ::(head:Int):Vector[IntN[Size]] =
    NonEmptyVector(head, this)
  def +(that:Vector[Size]):Vector[Size]
}