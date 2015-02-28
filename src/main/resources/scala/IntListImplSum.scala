case class IntListImpl[TailSize <: IntType]
  (head:Int, tail:IntList[TailSize])
extends IntList[IntN[TailSize]] {
  override def +(that:IntList[IntN[TailSize]]) = that match {
    case IntListImpl(h, t) => (head + h) :: (tail + t)
  }
}