// Compile to test
object BoolTypeSpecs {
  implicitly[TrueType  =:= TrueType]
  implicitly[FalseType =:= FalseType]
}