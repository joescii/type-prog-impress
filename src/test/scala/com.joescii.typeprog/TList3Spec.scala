package com.joescii.typeprog

import TypeLists._
import Nat._

object TList3Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]
  type Nat4 = NatN[Nat3]

  type List1 = Nat0 :+: Nat1 :+: Nat2 :+: NTNil
  type List2 = Nat1 :+: Nat2 :+: Nat3 :+: NTNil

  // So here is a type lambda...
  implicitly[List1#map[({type F[i <: Nat] = NatN[i]})#F] =:= List2]

  // In isolation:
  // ({type F[i <: Nat] = NatN[i]})#F

  // Notice that it is a structural type: {type F[i <: Nat] = NatN[i]}
  // ... where we 'invoke' the F type at the end,
  // causing it to 'return' the function F[i <: Nat] = NatN[i]
  // Hence the effect should be that every Nat type in the list should be incremented by one

  // Some more examples:
  type List3 = Nat2 :+: Nat3 :+: Nat4 :+: NTNil

  implicitly[List1#map[({type F[i <: Nat] = NatN[NatN[i]]})#F] =:= List3]
  implicitly[List1#map[({type F[i <: Nat] = i + Nat2})#F]      =:= List3]

  // HINT:
  // Thus far we have always accepted Nat types as type parameters with the syntax t[That <: Nat].
  // You can accept a type constructor/lambda with t[F[_] <: Nat] and apply F to existing Nat types.
}
