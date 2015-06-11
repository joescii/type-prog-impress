sealed trait NatVal {
  def plus(that:NatVal):NatVal
}
case object Nat0 extends NatVal {
  override def plus(that:NatVal) = that
}
case class NatN(prev:NatVal) extends NatVal {
  override def plus(that:NatVal) =
    NatN(prev plus that)
}