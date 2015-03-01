import shapeless.test.illTyped
// Compiles only if string DOESN'T compile
illTyped("implicitly[TrueType  =:= FalseType]")
illTyped("implicitly[FalseType =:= TrueType]")