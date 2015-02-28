val sum = (1 :: 2 :: IntNil) + (3 :: 4 :: IntNil)
sum should equal (4 :: 6 :: IntNil)

intercept[IllegalArgumentException](
  (1 :: 2 :: IntNil) + (5 :: IntNil)
)