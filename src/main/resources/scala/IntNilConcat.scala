case object IntNil extends IntList[Size0] {
  override def ++[ThatSize <: SizeType]
    (that:IntList[ThatSize]) = that
}