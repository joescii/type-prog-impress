package com.joescii.typeprog

import shapeless.test.illTyped

import Nat._

object Nat1Specs {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]

  implicitly[Nat0 =:= Nat0]
  illTyped("implicitly[Nat0 =:= Nat1]")

  implicitly[Nat0#plus[Nat1] =:= Nat1]
  implicitly[Nat1#plus[Nat1] =:= Nat2]
  implicitly[Nat1#plus[Nat2] =:= Nat3]

  implicitly[Nat0 + Nat1 =:= Nat1]
  implicitly[Nat1 + Nat1 =:= Nat2]
  implicitly[Nat1 + Nat2 =:= Nat3]
}
