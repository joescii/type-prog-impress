package com.joescii.typeprog

import shapeless.test.illTyped

import TypeLists._

object TList1Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]

  type List1 = Nat0 :+: Nat1 :+: Nat2 :+: NTNil
  type List2 = Nat3 :+: Nat2 :+: Nat1 :+: NTNil

//  type List1 = ::[Nat, Nat0, ::[Nat, Nat1, ::[Nat, Nat2, TNil[Nat]]]]
//  type List2 = ::[Nat, Nat3, ::[Nat, Nat2, ::[Nat, Nat1, TNil[Nat]]]]

  illTyped("implicitly[List1 =:= List2]")
  implicitly[List1#size =:= List2#size]
}
