implicitly[TrueType#Or[TrueType] =:= TrueType]
implicitly[TrueType#Or[FalseType] =:= TrueType]
implicitly[FalseType#Or[TrueType] =:= TrueType]
implicitly[FalseType#Or[FalseType] =:= FalseType]