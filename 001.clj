;; Multiples of 3 and 5
;; Problem 1
;;
;; If we list all the natural numbers below 10 that are
;; multiples of 3 or 5, we get 3, 5, 6 and 9. The sum
;; of these multiples is 23. Find the sum of all the
;; multiples of 3 or 5 below 1000.

;; implementation
(defn sum-of-multiples-of-three-or-five-below [n]
  (reduce + (set (concat (range 0 n 3) (range 0 n 5)))))

(print (time (sum-of-multiples-of-three-or-five-below 1000)))
