sealed trait IntVal {
  def plus(that:IntVal):IntVal
}
case object Int0 extends IntVal {
  override def plus(that:IntVal) = that
}
case class IntN(prev:IntVal) extends IntVal {
  override def plus(that:IntVal) =
    IntN(prev plus that)
}