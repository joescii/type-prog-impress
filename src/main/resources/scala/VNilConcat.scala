case object VNil extends Vector[Size0] {
  override def ++[ThatSize <: SizeType]
    (that:Vector[ThatSize]) = that
}