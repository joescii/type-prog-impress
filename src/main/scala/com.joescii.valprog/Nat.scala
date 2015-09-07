package com.joescii.valprog

sealed trait Nat {
  def +(that:Nat):Nat
}
case object Nat0 extends Nat {
  override def +(that:Nat) = that
}
case class NatN(prev:Nat) extends Nat {
  override def +(that:Nat) =
    NatN(prev + that)
}
