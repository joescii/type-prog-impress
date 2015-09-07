package com.joescii.valprog

import org.scalatest.{ FlatSpec, ShouldMatchers }

class NatSpecs extends FlatSpec with ShouldMatchers {
  "The NatVal" should "work for a few simple examples" in {
    val nat1 = NatN(Nat0)
    val nat2 = NatN(nat1)
    val nat3 = NatN(nat2)

    Nat0 + nat1 shouldEqual nat1
    nat1 + nat1 shouldEqual nat2
    nat1 + nat2 shouldEqual nat3
  }
}
