package com.joescii.valprog

sealed trait Nat {
  def plus(that:Nat):Nat
}
case object Nat0 extends Nat {
  override def plus(that:Nat) = that
}
case class NatN(prev:Nat) extends Nat {
  override def plus(that:Nat) =
    NatN(prev plus that)
}
