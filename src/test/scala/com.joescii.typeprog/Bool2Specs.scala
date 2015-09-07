package com.joescii.typeprog

import shapeless.test.illTyped

object Bool2Specs {
  implicitly[TrueType#And[TrueType] =:= TrueType]
  implicitly[TrueType#And[FalseType] =:= FalseType]
  implicitly[FalseType#And[TrueType] =:= FalseType]
  implicitly[FalseType#And[FalseType] =:= FalseType]

  illTyped("implicitly[True#And[True] =:= False]")
  illTyped("implicitly[True#And[False] =:= True]")
  illTyped("implicitly[False#And[True] =:= True]")
  illTyped("implicitly[False#And[False] =:= True]")

  // TODO: Did you implement And without touching True or False? It can be done :)
  // Use `this.type` to reference the type of the trait that is in scope.
  // Note that A And B => (A' Or B')' per De Morgan's Law.
}
