case object IntNil extends IntList[Int0] {
  override def +(that:IntList[Int0]) = this
}