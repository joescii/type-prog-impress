val sum = (1 :: 2 :: IntNil) + (3 :: 4 :: IntNil)
sum should equal (4 :: 6 :: IntNil)

// Screw IllegalArgument Exception.
// This crap won't even compile!
illTyped("(1 :: 2 :: IntNil) + (5 :: IntNil)")