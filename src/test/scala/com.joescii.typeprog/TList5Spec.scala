package com.joescii.typeprog

import TypeLists._

object TList5Spec {
  type List1 = FalseType :|: TrueType :|: FalseType :|: BTNil
  type List2 = FalseType :|: FalseType :|: FalseType :|: BTNil
  type List3 = TrueType :|: TrueType :|: BTNil

  implicitly[List1#size =:= List2#size]

  type Or = ({type F[a <: BoolType, b <: BoolType] = a#Or[b]})
  type And = ({type F[a <: BoolType, b <: BoolType] = a#And[b]})

  implicitly[List1#fold[FalseType, Or#F] =:= TrueType]
  implicitly[List2#fold[FalseType, Or#F] =:= FalseType]
  implicitly[List3#fold[FalseType, Or#F] =:= TrueType]
  implicitly[List1#fold[TrueType, And#F] =:= FalseType]
  implicitly[List2#fold[TrueType, And#F] =:= FalseType]
  implicitly[List3#fold[TrueType, And#F] =:= TrueType]
}
