sealed trait BoolVal  {
sealed trait BoolType {
  def  not :  BoolVal
  type Not <: BoolType
  def  or(that  : BoolVal)   : BoolVal
  type Or[That <: BoolType] <: BoolType
}