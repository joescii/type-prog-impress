package com.joescii

package typeprog {
  sealed trait BoolVal {
    def not:BoolVal
    def or(that:BoolVal):BoolVal
  }

  case object TrueVal extends BoolVal {
    override val not = FalseVal
    override def or(that:BoolVal) = TrueVal
  }

  case object FalseVal extends BoolVal {
    override val not = TrueVal
    override def or(that:BoolVal) = that
  }
}

package typeprog2 {
  sealed trait BoolVal
  case object TrueVal extends BoolVal
  case object FalseVal extends BoolVal
}