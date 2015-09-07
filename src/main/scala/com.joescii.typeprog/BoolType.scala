package com.joescii

package typeprog {
  sealed trait BoolType {
    type Not <: BoolType
    type Or[That <: BoolType] <: BoolType
    type And[That <: BoolType] = this.type#Not#Or[That#Not]#Not
    type Imp[That <: BoolType] = this.type#Not#Or[That]
  }
  sealed trait TrueType extends BoolType {
    override type Not = FalseType
    override type Or[That <: BoolType] = TrueType
  }
  sealed trait FalseType extends BoolType {
    override type Not = TrueType
    override type Or[That <: BoolType] = That
  }

  object BoolType {
    type \/[A <: BoolType, B <: BoolType] = A#Or[B]
    type /\[A <: BoolType, B <: BoolType] = A#And[B]
    type ->[A <: BoolType, B <: BoolType] = A#Imp[B]
  }
}

package typeprog2 {
  sealed trait BoolType
  sealed trait TrueType extends BoolType
  sealed trait FalseType extends BoolType
}