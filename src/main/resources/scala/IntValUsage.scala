val int1 = IntN(Int0)
val int2 = IntN(int1)
val int3 = IntN(int2)

Int0 should equal (Int0)
Int0 should not equal (int1)

(Int0 plus int1) should equal (int1)
(int1 plus int1) should equal (int2)
(int1 plus int2) should equal (int3)