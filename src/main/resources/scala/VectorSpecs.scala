val sum = (1 :: 2 :: VNil) + (3 :: 4 :: VNil)
sum should equal (4 :: 6 :: VNil)

// Screw IllegalArgument Exception.
// This crap won't even compile!
illTyped("(1 :: 2 :: VNil) + (5 :: VNil)")