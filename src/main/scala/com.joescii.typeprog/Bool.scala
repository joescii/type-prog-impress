package com.joescii.typeprog

sealed trait Bool {
  type Not <: Bool
  type Or[That <: Bool] <: Bool
  type And[That <: Bool] = this.type#Not#Or[That#Not]#Not
  type Imp[That <: Bool] = this.type#Not#Or[That]
}
sealed trait True extends Bool {
  type Not = False
  type Or[That <: Bool] = True
}
sealed trait False extends Bool {
  type Not = True
  type Or[That <: Bool] = That
}

object Bool {
  type \/[A <: Bool, B <: Bool] = A#Or[B]
  type /\[A <: Bool, B <: Bool] = A#And[B]
  type ->[A <: Bool, B <: Bool] = A#Imp[B]
}