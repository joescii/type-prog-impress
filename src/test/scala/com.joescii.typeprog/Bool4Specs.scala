package com.joescii.typeprog

// Put your new types in the Bool companion object.
import BoolType._

object Bool4Specs {
  // A type with two parameters
  // can be written in infix notation:
  implicitly[\/[FalseType, FalseType]
    =:= (FalseType \/ FalseType)]

  implicitly[TrueType \/ FalseType =:= TrueType]
  implicitly[TrueType /\ FalseType =:= FalseType]
  implicitly[TrueType -> FalseType =:= FalseType]
}
