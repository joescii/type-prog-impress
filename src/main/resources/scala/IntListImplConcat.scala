case class IntListImpl[TailSize <: IntType]
  (head:Int, tail:IntList[TailSize])
extends IntList[IntN[TailSize]] {

  override def ++[ThatSize <: SizeType]
  (that:IntList[ThatSize]) =
    IntListImpl(head, tail++that)
}