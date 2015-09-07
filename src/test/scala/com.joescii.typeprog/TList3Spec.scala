package com.joescii.typeprog

import Nat._

object TList3Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]
  type Nat4 = NatN[Nat3]

  type L1 = Nat0 :: Nat1 :: Nat2 :: TNil
  type L2 = Nat1 :: Nat2 :: Nat3 :: TNil

  // Holy crap y'all, a type lambda...
  type LM = L1#map[({type F[i <: Nat] = NatN[i]})#F]
  implicitly[LM =:= L2]

  // In isolation:
  // ({type F[i <: Nat] = NatN[i]})#F

  // Notice that it is a structural type: {type F[i <: Nat] = NatN[i]}
  // ... where we 'invoke' the F type at the end,
  // causing it to 'return' the function F[i <: Nat] = NatN[i]
  // Hence the effect should be that every Nat type in the list should be incremented by one

  // Some more examples:
  type List3 = Nat2 :: Nat3 :: Nat4 :: TNil

  implicitly[L1#map[({type F[i <: Nat] = NatN[NatN[i]]})#F] =:= List3]
  implicitly[L1#map[({type F[i <: Nat] = i + Nat2})#F]      =:= List3]

  // HINT:
  // Thus far we have always accepted Nat types as type parameters with the syntax t[That <: Nat].
  // You can accept a type constructor/lambda with t[F[_] <: Nat] and apply F to existing Nat types.
}
