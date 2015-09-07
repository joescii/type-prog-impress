package com.joescii.typeprog

// Put your new types in the Bool companion object.
import Bool._

object Bool4Specs {
  // A type with two parameters can be written in infix notation:
  implicitly[\/[False, False] =:= (False \/ False)]

  implicitly[True \/ False =:= True]
  implicitly[True /\ False =:= False]
  implicitly[True -> False =:= False]
}
