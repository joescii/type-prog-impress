implicitly[TrueType#Not  =:= FalseType]
implicitly[FalseType#Not =:= TrueType]
illTyped("implicitly[TrueType#Not  =:= TrueType]")
illTyped("implicitly[FalseType#Not =:= FalseType]")