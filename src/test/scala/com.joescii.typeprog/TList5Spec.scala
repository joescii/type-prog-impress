package com.joescii.typeprog

import TypeLists._

object TList5Spec {
  type List1 = False :|: True :|: False :|: BTNil
  type List2 = False :|: False :|: False :|: BTNil
  type List3 = True :|: True :|: BTNil

  implicitly[List1#size =:= List2#size]

  type Or = ({type F[a <: Bool, b <: Bool] = a#Or[b]})
  type And = ({type F[a <: Bool, b <: Bool] = a#And[b]})

  implicitly[List1#fold[False, Or#F] =:= True]
  implicitly[List2#fold[False, Or#F] =:= False]
  implicitly[List3#fold[False, Or#F] =:= True]
  implicitly[List1#fold[True, And#F] =:= False]
  implicitly[List2#fold[True, And#F] =:= False]
  implicitly[List3#fold[True, And#F] =:= True]
}
