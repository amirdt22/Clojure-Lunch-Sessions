(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(meditations
  "Destructuring is an arbiter: it breaks up arguments"
  (= ":bar:foo" ((fn [[a b]] (str b a))
           [:foo :bar]))

  "Whether in function definitions"
  (= (str "First comes love, "
          "then comes marriage, "
          "then comes Clojure with the baby carriage")
     ((fn [[a b c]] (str "First comes " a ", then comes " b ", then comes " c " with the baby carriage" ))
       ["love" "marriage" "Clojure"]))

  "Or in let expressions"
  (= "Rich Hickey aka The Clojurer aka Go Time aka Macro Killah"
     (let [[first-name last-name & aliases]
             (list "Rich" "Hickey" "The Clojurer" "Go Time" "Macro Killah")]
       (str first-name " " last-name " aka " (clojure.string/join " aka " aliases))))

  "Or in let expressions ..."
  (= "Rich Hickey aka The Clojurer aka Go Time aka Macro Killah"
     (let [[first-name last-name & aliases]
             (list "Rich" "Hickey" "The Clojurer" "Go Time" "Macro Killah")]
       (str first-name " " last-name (str (map (fn [a] (str  " aka " a)) aliases)))))

  "You can regain the full argument if you like arguing"
  (= {:original-parts ["Steven" "Hawking"] :named-parts {:first "Steven" :last "Hawking"}}
     (let [[first-name last-name :as full-name] ["Steven" "Hawking"]]
       __))

  "Break up maps by key"
  (= "123 Test Lane, Testerville, TX"
     (let [{street-address :street-address, city :city, state :state} test-address]
            __))

  "Or more succinctly"
  (= "123 Test Lane, Testerville, TX"
     (let [{:keys [street-address __ __]} test-address]
            __))

  "All together now!"
  (= "Test Testerson, 123 Test Lane, Testerville, TX"
     (___ ["Test" "Testerson"] test-address))
)
