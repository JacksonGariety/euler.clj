;; Problem 5
;;
;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;;
;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

;; implementation
;;
;; (defn smallest-divisible-by [s]
;;   (loop [i 1]
;;     (if (zero? (reduce #(+ %1 (rem i %2)) s))
;;       i
;;       (recur (+ 1 i)))))
;;
;; I'm pretty sure that this works but it causes a
;; buffer overflow in emacs. Might be faster if
;; compiled to bytecode.
;;
;; Basically what it does is start counting up from
;; 1 to infinity and going over the sequence produced
;; by (range 1 21). It's really slow.

(require '[clojure.math.numeric-tower :as Math])

(defn smallest-divisible-by [s]
  (reduce #(Math/lcm %1 %2) s))

;; This puppy is much, much faster. Unfortunately,
;; I didn't think to use the lcm function until
;; I looked it up. On top of that, I don't
;; remember exactly why this is so much faster!

(print (time (smallest-divisible-by (range 1 21))))
