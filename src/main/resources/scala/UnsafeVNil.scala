case object VNil extends Vector {
  override def +(that:Vector) = {
    require(that == VNil)
    this
  }
  override val size = 0
}