(import '[java.io BufferedReader InputStreamReader])

(println (class System/in))
(time (let [reader (BufferedReader. (InputStreamReader. System/in))
            file-data (StringBuffer.)
            buffer (char-array 4096)]
        (loop [total 0]
          (let [num-read (.read reader buffer)]
            (if (not= -1 num-read)
              (do
                (.append file-data buffer 0 num-read)
                (recur (+ total num-read)))
              (str file-data))))))
