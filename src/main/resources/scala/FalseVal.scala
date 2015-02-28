case object FalseVal extends BoolVal {
  override val not = TrueVal
  override def or(that:BoolVal) = that
}