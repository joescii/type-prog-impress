package com.joescii.typeprog

import Nat._

object TList4Spec {
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]
  type Nat3 = NatN[Nat2]
  type Nat4 = NatN[Nat3]
  type Nat6 = NatN[NatN[Nat4]]

  type L1 = Nat2 :: Nat1 :: Nat0 :: Nat1 :: TNil
  type LF = L1#fold[Nat0,
    ({type F[A <: Nat, B <: Nat] = A + B})#F
  ]
  implicitly[LF =:= Nat4]

  type L2 = Nat1 :: Nat1 :: Nat3 :: Nat2 :: Nat1 :: TNil
  implicitly[L2#fold[Nat1, ({type F[A <: Nat, B <: Nat] = A * B})#F] =:= Nat6]
}
