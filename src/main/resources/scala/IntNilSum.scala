case object IntNil extends IntList[Int0] {
  override def +(that:IntList[IntType]) =
    this
}