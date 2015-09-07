package com.joescii.typeprog

import Nat._

object Nat3Specs {
  // Can you generate a Nat so large that it breaks the compiler with a java.lang.StackOverflowError?
  type Nat1 = NatN[Nat0]
  type Nat2 = NatN[Nat1]

//  val a:Nat2 * Nat2 * Nat2 * Nat2 * Nat2 * Nat2 * Nat2 * Nat2 * Nat2 * Nat2 = null
}
