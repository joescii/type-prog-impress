package com.joescii.typeprog

import org.scalatest.{ FlatSpec, Matchers }
import shapeless.test.illTyped

class Vect1Specs extends FlatSpec with Matchers {
  "Vector addition" should "compute [1, 2] + [3, 4] => [4, 6]" in {
    val sum = (1 :: 2 :: VNil) + (3 :: 4 :: VNil)
    sum shouldEqual 4 :: 6 :: VNil
  }

  "Vector addition" should "fail to compile [1, 2] + [5]" in {
    illTyped("(1 :: 2 :: VNil) + (5 :: VNil)")
  }
}
