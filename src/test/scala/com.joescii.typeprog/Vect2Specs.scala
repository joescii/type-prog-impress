package com.joescii.typeprog

import shapeless.test.illTyped

object Vect2Specs {
  illTyped("(1 :: 2 :: VNil) + (5 :: VNil)")
}
