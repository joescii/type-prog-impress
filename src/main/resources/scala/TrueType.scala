sealed trait TrueType extends BoolType {
  override type Not = FalseType
  override type Or[That <: BoolType] =
    TrueType
}