sealed trait Vector[Size <: IntType]
case object VNil extends Vector[Int0]
case class NonEmptyVector[TailSize <: IntType]
  (head:Int, tail:Vector[TailSize])
  extends Vector[IntN[TailSize]]