case object  FalseVal  extends BoolVal  {
sealed trait FalseType extends BoolType {
  override val  not = TrueVal
  override type Not = TrueType
  override def  or(that  : BoolVal ) = that
  override type Or[That <: BoolType] = That
}
