case class NonEmptyVector[TailSize <: IntType]
  (head:Int, tail:Vector[TailSize])
  extends Vector[IntN[TailSize]] {

  override def ++[ThatSize <: SizeType]
  (that:Vector[ThatSize]) =
    NonEmptyVector(head, tail++that)
}