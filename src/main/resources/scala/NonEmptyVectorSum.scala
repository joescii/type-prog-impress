case class NonEmptyVector[TailSize <: IntType]
  (head:Int, tail:Vector[TailSize])
  extends Vector[IntN[TailSize]] {
  override def +(that:Vector[IntN[TailSize]]) = that match {
    case NonEmptyVector(h, t) => (head + h) :: (tail + t)
  }
}