sealed trait IntList[Size <: IntType]
case object IntNil extends IntList[Int0]
case class IntListImpl[TailSize <: IntType]
  (head:Int, tail:IntList) extends IntList