val sum =
  ((1 :: 2 :: IntNil) ++ (3 :: IntNil)) +
  (4 :: 5 :: 6 :: IntNil)
sum should equal (5 :: 7 :: 9 :: IntNil)