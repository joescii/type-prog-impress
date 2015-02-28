sealed trait BoolVal {
  def not:BoolVal
  def or(that:BoolVal):BoolVal
}