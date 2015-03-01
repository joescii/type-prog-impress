case object  TrueVal  extends BoolVal  {
sealed trait TrueType extends BoolType {
  override val  not = FalseVal
  override type Not = FalseType
  override def  or(that  : BoolVal ) = TrueVal
  override type Or[That <: BoolType] = TrueType
}