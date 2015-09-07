package com.joescii.typeprog

import shapeless.test.illTyped

object Bool3Specs {
  implicitly[TrueType#Imp[TrueType] =:= TrueType]
  implicitly[TrueType#Imp[FalseType] =:= FalseType]
  implicitly[FalseType#Imp[TrueType] =:= TrueType]
  implicitly[FalseType#Imp[FalseType] =:= TrueType]

  illTyped("implicitly[True#Imp[True] =:= False]")
  illTyped("implicitly[True#Imp[False] =:= True]")
  illTyped("implicitly[False#Imp[True] =:= False]")
  illTyped("implicitly[False#Imp[False] =:= False]")

  // TODO: Imp can also be implemented solely in Bool.
  // Note that A Imp B = A' Or B
}
