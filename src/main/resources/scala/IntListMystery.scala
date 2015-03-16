sealed trait IntList[Size <: SizeType] {
  def ???[ThatSize <: SizeType]
    (that:IntList[ThatSize])
    :IntList[Size#plus[ThatSize]]
}