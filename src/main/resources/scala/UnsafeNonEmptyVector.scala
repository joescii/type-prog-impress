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