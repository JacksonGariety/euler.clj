;; Problem 4
;;
;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product
;; of two 2-digit numbers is 9009 = 91 × 99.
;;
;; Find the largest palindrome made from the
;; product of two 3-digit numbers.

;; implementation
(defn largest-palindrome []
  (last (sort (filter #(let [l (seq (str %))]
                         (= l (reverse l)))
                      (for [x (range 100 999)
                            y (range 100 999)
                            :when (>= y x)]
                        (* x y))))))

(print (time (largest-palindrome)))
