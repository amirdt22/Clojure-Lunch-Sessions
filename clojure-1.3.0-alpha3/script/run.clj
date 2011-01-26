#_(time
   (do
     (slurp "words")
     nil))

(import '[java.io BufferedReader InputStreamReader])
(time
 (let [reader (BufferedReader. (InputStreamReader. (java.io.FileInputStream. "words")))
       file-data (StringBuffer.)
       buffer (char-array 4096)]
   (loop [total 0]
     (let [num-read (.read reader buffer)]
       (if (not= -1 num-read)
         (do
           (.append file-data buffer 0 num-read)
           (recur (+ total num-read))))))))

