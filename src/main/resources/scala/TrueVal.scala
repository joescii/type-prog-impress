case object TrueVal extends BoolVal {
  override val not = FalseVal
  override def or(that:BoolVal) = TrueVal
}