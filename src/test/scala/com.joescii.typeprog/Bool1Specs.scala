package com.joescii.typeprog

import shapeless.test.illTyped

object Bool1Specs {
  implicitly[True  =:= True]
  implicitly[False =:= False]

  implicitly[True#Not  =:= False]
  implicitly[False#Not =:= True]

  implicitly[True#Or[True] =:= True]
  implicitly[True#Or[False] =:= True]
  implicitly[False#Or[True] =:= True]
  implicitly[False#Or[False] =:= False]

  illTyped("implicitly[True  =:= False]")
  illTyped("implicitly[False =:= True]")

  illTyped("implicitly[True#Not  =:= True]")
  illTyped("implicitly[False#Not =:= False]")

  illTyped("implicitly[True#Or[True] =:= False]")
  illTyped("implicitly[True#Or[False] =:= False]")
  illTyped("implicitly[False#Or[True] =:= False]")
  illTyped("implicitly[False#Or[False] =:= True]")
}
