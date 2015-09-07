package com.joescii.typeprog

import org.scalatest.{ FlatSpec, Matchers }

class Vect3Specs extends FlatSpec with Matchers {
  // Now add the following mysteriously-named function signature to your Vector:
  // def ??[ThatSize <: Nat](that:Vector[ThatSize]):Vector[Size + ThatSize]

  // The name of this new function is purposefully obfuscated.
  // However, the types severely limit the possible implementations.
  // Based on the type, what is a reasonable implementation of this new function?

  // Once you decide that, update the test below and implement the function.
  // Rename it to something more meaningful.

  "The mystery Vector function" should "compute something reasonable" in {
    val v1 = (5 :: 2 :: VNil)
    val v2 = (4 :: 1 :: 3 :: VNil)
    val v3 = (5 :: 2 :: 4 :: 1 :: 3 :: VNil)

    (v1 ++ v2) should equal (v3)
  }
}
