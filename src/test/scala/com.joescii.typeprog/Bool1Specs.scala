package com.joescii.typeprog

import shapeless.test.illTyped

object Bool1Specs {
  implicitly[TrueType  =:= TrueType]
  implicitly[FalseType =:= FalseType]

  implicitly[TrueType#Not  =:= FalseType]
  implicitly[FalseType#Not =:= TrueType]

  implicitly[TrueType#Or[TrueType] =:= TrueType]
  implicitly[TrueType#Or[FalseType] =:= TrueType]
  implicitly[FalseType#Or[TrueType] =:= TrueType]
  implicitly[FalseType#Or[FalseType] =:= FalseType]

  illTyped("implicitly[True  =:= False]")
  illTyped("implicitly[False =:= True]")

  illTyped("implicitly[True#Not  =:= True]")
  illTyped("implicitly[False#Not =:= False]")

  illTyped("implicitly[True#Or[True] =:= False]")
  illTyped("implicitly[True#Or[False] =:= False]")
  illTyped("implicitly[False#Or[True] =:= False]")
  illTyped("implicitly[False#Or[False] =:= True]")
}
