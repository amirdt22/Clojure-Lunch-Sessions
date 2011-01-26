(require '[clojure.java.io :as jio])

(defn slurp5
  "Reads the file named by f using the encoding enc into a string
  and returns it."
  {:added "1.0"}
  ([f & opts]
     (let [sb (StringBuilder.)
           buffer (char-array 4096)]
       (with-open [#^java.io.Reader r (jio/reader f)]
         (loop [num-read (.read r buffer)]
           (if (= -1 num-read)
             (str sb)
             (do
               (.append sb buffer 0 num-read)
               (recur (.read r buffer)))))))))

(time (slurp5 *in*))
