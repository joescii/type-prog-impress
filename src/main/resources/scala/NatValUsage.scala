val nat1 = NatN(Nat0)
val nat2 = NatN(nat1)
val nat3 = NatN(nat2)

Nat0 should equal (Nat0)
Nat0 should not equal (nat1)

(Nat0 plus nat1) should equal (nat1)
(nat1 plus nat1) should equal (nat2)
(nat1 plus nat2) should equal (nat3)