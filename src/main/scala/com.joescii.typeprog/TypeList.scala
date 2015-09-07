package com.joescii.typeprog

import Nat._

sealed trait TypeList {
  type size <: Nat
  type reduce <: Nat
  type map[F[_ <: Nat] <: Nat] <: TypeList
  type fold[A <: Nat, F[_ <: Nat, _ <: Nat] <: Nat] <: Nat
}
sealed trait TNil extends TypeList {
  type size = Nat0
  type reduce = Nat0
  type map[F[_ <: Nat] <: Nat] = TNil
  type fold[A <: Nat, F[_ <: Nat, _ <: Nat] <: Nat] = A
}
sealed trait ::[H <: Nat, T <: TypeList] extends TypeList {
  type size = NatN[T#size]
  type reduce = H + (T#reduce)
  type map[F[_ <: Nat] <: Nat] = F[H] :: T#map[F]
  type fold[A <: Nat, F[_ <: Nat, _ <: Nat] <: Nat] = F[H, T#fold[A, F]]
}
