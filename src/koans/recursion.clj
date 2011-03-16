(defn is-even? [n]
  (if (= n 0) true
      (not (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n n acc true]
    (if (= n 0) acc
        (recur (dec n) (not acc)))))

(defn factorial [n]
  (if (<= n 1) 1
      (* (factorial (dec n)) n)))

(meditations
  "Recursion ends with a base case"
  (= true (is-even? 0))

  "And starts by moving toward that base case"
  (= false (is-even? 1))

  "Having too many stack frames requires explicit tail calls with recur"
  (= false (is-even-bigint? 100003N))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (= (factorial 1000N) (factorial 1000N))

  "But what happens when the machine limits you?"
  (= (factorial 10000N) (factorial 10000N)))
