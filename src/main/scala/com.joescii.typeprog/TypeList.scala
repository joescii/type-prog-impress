package com.joescii.typeprog

sealed trait TypeList[E] {
  type size <: Nat
//  type reduce <: E
  type map[F[_ <: E] <: E] <: TypeList[E]
  type fold[A <: E, F[_ <: E, _ <: E] <: E] <: E
}
sealed trait TNil[E] extends TypeList[E] {
  type size = Nat0
//  type reduce = Nat0
  type map[F[_ <: E] <: E] = TNil[E]
  type fold[A <: E, F[_ <: E, _ <: E] <: E] = A
}
sealed trait ::[E, H <: E, T <: TypeList[E]] extends TypeList[E] {
  type size = NatN[T#size]
//  type reduce = H#plus[T#reduce]
  type map[F[_ <: E] <: E] = ::[E, F[H], T#map[F]]
  type fold[A <: E, F[_ <: E, _ <: E] <: E] = F[H, T#fold[A, F]]
}

object TypeLists {
  type NTNil = TNil[Nat]
  type :+:[H <: Nat, T <: TypeList[Nat]] = ::[Nat, H, T]

  type BTNil = TNil[BoolType]
  type :|:[H <: BoolType, T <: TypeList[BoolType]] = ::[BoolType, H, T]
}