val sum =
  ((1 :: 2 :: VNil) ++ (3 :: VNil)) +
  (4 :: 5 :: 6 :: VNil)
sum should equal (5 :: 7 :: 9 :: VNil)