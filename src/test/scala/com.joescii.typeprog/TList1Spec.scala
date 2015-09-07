package com.joescii.typeprog

import shapeless.test.illTyped

object TList1Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]

  type L = Nat0 :: Nat1 :: Nat2 :: TNil
  implicitly[L#size =:= Nat3]
  illTyped("implicitly[List1#size =:= Nat2]")

  type L2 = Nat3 :: Nat2 :: Nat1 :: TNil

  illTyped("implicitly[List1 =:= List2]")
  implicitly[L#size =:= L2#size]
}
