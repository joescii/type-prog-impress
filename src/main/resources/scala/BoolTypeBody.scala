sealed trait BoolType {
  type Not <: BoolType
  type Or[That <: BoolType] <: BoolType
}