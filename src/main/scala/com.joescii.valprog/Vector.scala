package com.joescii.valprog

sealed trait Vector {
  // Convenience vector constructor
  def ::(head:Int):Vector = NonEmptyVector(head, this)
  // Vector addition
  def +(that:Vector):Vector
  def size:Int
}
case object VNil extends Vector {
  override def +(that:Vector) = {
    require(that == VNil)
    this
  }
  override val size = 0
}
case class NonEmptyVector(head:Int, tail:Vector)
  extends Vector {
  override def +(that:Vector) = {
    require(that.size == size)
    that match {
      case NonEmptyVector(h, t) => (head + h) :: (tail + t)
    }
  }
  override val size = 1 + tail.size
}
