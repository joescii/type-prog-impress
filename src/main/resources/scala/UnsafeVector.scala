sealed trait Vector {
  def size:Int
}
case object VNil extends Vector {
  override val size = 0
}
case class NonEmptyVector(head:Int, tail:Vector)
  extends Vector {
    override val size = 1 + tail.size
}