case class IntListImpl(head:Int, tail:IntList)
  extends IntList {
  override def +(that:IntList) = {
    require(that.size == size)
    that match {
      case IntListImpl(h, t) => (head + h) :: (tail + t)
    }
  }
  override val size = 1 + tail.size
}