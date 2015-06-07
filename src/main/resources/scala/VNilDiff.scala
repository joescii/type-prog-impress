case object VNil extends Vector {
case object VNil extends Vector[Int0] {
  override def +(that:Vector) = {
  override def +(that:Vector[IntType]) =
    require(that == VNil)
    // require not needed, type-checked
    this }
    this
  override val size = 0
  // size not needed for checking
}