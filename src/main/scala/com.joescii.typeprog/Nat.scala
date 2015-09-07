package com.joescii.typeprog

sealed trait Nat {
  type plus[That <: Nat] <: Nat
  type times[That <: Nat] <: Nat
}
sealed trait Nat0 extends Nat {
  type plus[That <: Nat] = That
  type times[That <: Nat] = Nat0
}
sealed trait NatN[Prev <: Nat] extends Nat {
  type plus[That <: Nat] = NatN[Prev#plus[That]]
  type times[That <: Nat] = That#plus[That#times[Prev]]
}

object Nat {
  type +[A <: Nat, B <: Nat] = A#plus[B]
  type *[A <: Nat, B <: Nat] = A#times[B]
}
