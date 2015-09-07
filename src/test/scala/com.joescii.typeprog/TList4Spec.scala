package com.joescii.typeprog

import Nat._

object TList4Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]
  type Nat4 = NatN[Nat3]
  type Nat6 = NatN[NatN[Nat4]]

  type List1 = Nat2 :: Nat1 :: Nat0 :: Nat1 :: TNil
  implicitly[List1#fold[Nat0, ({type F[a <: Nat, b <: Nat] = a + b})#F] =:= Nat4]

  type List2 = Nat1 :: Nat1 :: Nat3 :: Nat2 :: Nat1 :: TNil
  implicitly[List2#fold[Nat1, ({type F[a <: Nat, b <: Nat] = a * b})#F] =:= Nat6]
}
