sealed trait Vector[Size <: SizeType] {
  def ???[ThatSize <: SizeType]
    (that:Vector[ThatSize])
    :Vector[Size#plus[ThatSize]]
}