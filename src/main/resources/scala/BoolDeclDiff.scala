sealed trait BoolVal
sealed trait BoolType
case object  TrueVal   extends BoolVal
sealed trait TrueType  extends BoolType
case object  FalseVal  extends BoolVal
sealed trait FalseType extends BoolType