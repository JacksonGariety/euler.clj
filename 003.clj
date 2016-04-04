;; Problem 3
;;
;; The prime factors of 13195 are 5, 7, 13 and 29.
;;
;; What is the largest prime factor of the number 600851475143 ?

;;(use 'clojure.math.numeric-tower)

;; implementation
(defn largest-prime-factor-of [n]
  (loop [f 2
         i n]
    (cond (= f i) f
          (= (rem i f) 0) (recur f (quot i f))
          :else (recur (+ f 1) i))))

;; execution
(largest-prime-factor-of 600851475143)
