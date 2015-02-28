case object IntNil extends IntList {
  override def +(that:IntList) = {
    require(that == IntNil)
    this
  }
  override val size = 0
}