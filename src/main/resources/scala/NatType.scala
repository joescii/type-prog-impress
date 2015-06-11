sealed trait NatType {
  type plus[That <: NatType] <: NatType
}
sealed trait Nat0 extends NatType {
  override type plus[That <: NatType] = That
}
sealed trait NatN[Prev <: NatType] extends NatType {
  override type plus[That <: NatType] =
    NatN[Prev#plus[That]]
}