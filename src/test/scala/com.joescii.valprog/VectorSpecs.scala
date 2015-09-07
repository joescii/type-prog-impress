package com.joescii.valprog

import org.scalatest.{ FlatSpec, ShouldMatchers }

class VectorSpecs extends FlatSpec with ShouldMatchers {
  "The unsafe Vector" should "work for a few simple examples" in {
    val sum = (1 :: 2 :: VNil) + (3 :: 4 :: VNil)
    sum should equal (4 :: 6 :: VNil)

    intercept[IllegalArgumentException](
      (1 :: 2 :: VNil) + (5 :: VNil)
    )
  }
}
