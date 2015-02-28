sealed trait IntList {
  def size:Int
}
case object IntNil extends IntList {
  override val size = 0
}
case class IntListImpl(head:Int, tail:IntList)
  extends IntList {
    override val size = 1 + tail.size
}