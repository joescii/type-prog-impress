sealed trait Vector {
  // Convenience vector constructor
  def ::(head:Int):Vector = NonEmptyVector(head, this)
  // Vector addition
  def +(that:Vector):Vector
  def size:Int
}