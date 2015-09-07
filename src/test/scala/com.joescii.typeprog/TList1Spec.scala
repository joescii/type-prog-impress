package com.joescii.typeprog

import shapeless.test.illTyped

object TList1Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]

  type List1 = Nat0 :: Nat1 :: Nat2 :: TNil
  type List2 = Nat3 :: Nat2 :: Nat1 :: TNil

  illTyped("implicitly[List1 =:= List2]")
  implicitly[List1#size =:= List2#size]
}
