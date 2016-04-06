(ns euler.core
  (:use [euler.001]
        [euler.002]
        [euler.003]
        [euler.004]
        [euler.005]
        [euler.006]))

(defn -main [& args]
  (let [n (Integer. (re-find  #"\d+" (first args) ))
        f (case n
            1 #(sum-of-multiples-of-three-or-five-below 1000)
            2 #(sum-of-even-fibonaccis-below-2 4000000)
            3 #(largest-prime-factor-of 600851475143)
            4 #(largest-palindrome)
            5 #(smallest-divisible-by (range 1 21))
            6 #(sum-square-difference (range 101)))]
    (println (time (f)))))
