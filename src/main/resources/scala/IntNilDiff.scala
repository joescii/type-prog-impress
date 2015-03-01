case object IntNil extends IntList {
case object IntNil extends IntList[Int0] {
  override def +(that:IntList) = {
  override def +(that:IntList[IntType]) =
    require(that == IntNil)
    // require not needed, type-checked
    this }
    this
  override val size = 0
  // size not needed for checking
}