;; Special Pythagorean triplet
;; Problem 9
;; 
;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;;
;; a^2 + b^2 = c^2
;; 
;; For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
;;
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc

(require '[clojure.math.numeric-tower :as Math])

(defn pythagorean-triplet-product [sum]
  (loop [a (quot sum 3)
         b (/ (- (/ (Math/expt sum 2) 2) (* sum a)) (- sum a))]
    (if (integer? b)
      )
    1))

(print (time (pythagorean-triplet-product 1000)))
