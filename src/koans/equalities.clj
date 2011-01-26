(meditations
  "We shall contemplate truth by testing reality, via equality."
  (= true true)

  "To understand reality, we must compare our expectations against reality."
  (= 2 (+ 1 1))

  "You can test equality of many things"
  (= (+ 3 4) 7 (+ 2 5))

  "Some things may appear different, but be the same"
  (= 2 2/1 (* 2 1))

  "You cannot generally float to heavens of integers"
  (= false (= 2 2.0))

  "But a looser equality is also possible"
  (== 2.0 2 2.000000)

  "But another looser equality is also possible"
  (== 5.0E99999 2.00E10000)

  "When things cannot be equal, they must be different"
  (not= nil 0))
