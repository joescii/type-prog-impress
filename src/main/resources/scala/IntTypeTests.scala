type Int1 = IntN[Int0]
type Int2 = IntN[Int1]
type Int3 = IntN[Int2]

implicitly[Int0 =:= Int0]
illTyped("implicitly[Int0 =:= Int1]")

implicitly[Int0#plus[Int1] =:= Int1]
implicitly[Int1#plus[Int1] =:= Int2]
implicitly[Int1#plus[Int2] =:= Int3]