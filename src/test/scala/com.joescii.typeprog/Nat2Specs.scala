package com.joescii.typeprog

import Nat._

object Nat2Specs {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]
  type Nat6 = NatN[NatN[NatN[Nat3]]]

  implicitly[Nat3#times[Nat2] =:= Nat6]

  implicitly[Nat3 * Nat2 =:= Nat6]
}
