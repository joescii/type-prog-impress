sealed trait IntType {
  type plus[That <: IntType] <: IntType
}
sealed trait Int0 extends IntType {
  override type plus[That <: IntType] = That
}
sealed trait IntN[Prev <: IntType] extends IntType {
  override type plus[That <: IntType] =
    IntN[Prev#plus[That]]
}