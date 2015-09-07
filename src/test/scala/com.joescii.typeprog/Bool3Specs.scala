package com.joescii.typeprog

import shapeless.test.illTyped

object Bool3Specs {
  implicitly[True#Imp[True] =:= True]
  implicitly[True#Imp[False] =:= False]
  implicitly[False#Imp[True] =:= True]
  implicitly[False#Imp[False] =:= True]

  illTyped("implicitly[True#Imp[True] =:= False]")
  illTyped("implicitly[True#Imp[False] =:= True]")
  illTyped("implicitly[False#Imp[True] =:= False]")
  illTyped("implicitly[False#Imp[False] =:= False]")

  // TODO: Imp can also be implemented solely in Bool.
  // Note that A Imp B = A' Or B
}
