;; Problem 2
;;
;; Each new term in the Fibonacci sequence is
;; generated by adding the previous two terms.
;; By starting with 1 and 2, the first 10 terms
;; will be:
;;
;; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;;
;; By considering the terms in the Fibonacci
;; sequence whose values do not exceed four
;; million, find the sum of the even-valued
;; terms.

;; implementation

;; This first one generates a full fibonacci sequence in
;; a rather imperative fashion. It's not terribly
;; efficient

(ns euler.002)

(defn sum-of-even-fibonaccis-below [n]
  (loop [a 1
         b 2
         s 0]
    (if (<= b n)
      (recur b
             (+ a b)
             (if (zero? (rem b 2))
               (+ s b)
               s))
      s)))

;; The second version uses a third variable, c,
;; and it's over three times as fast!

(defn sum-of-even-fibonaccis-below-2 [n]
  (loop [a 1
         b 1
         c 2
         s 0]
    (if (<= b n)
        (recur (+ b c)
               (+ c (+ b c))
               (+ (+ b c) (+ c (+ b c)))
               (+ s c))
      s)))

;; This is my attempt at making it more like idiomatic
;; clojure. It's really, really slow. (15x slower than #2!)

(defn sum-of-even-fibonaccis-below-3 [n]
  (defn fib [a b] (lazy-seq (cons a (fib b (+ b a)))))
  (reduce + (take-while (partial >= n) (take-nth 3 (fib 0 1)))))

;; Why is this third implementation so much slower???
;;
;; By simply returning the sequence and not reducing it
;; we get a 20x speed increase. Why would such a simple
;; and idiomatic procedure [(reduce +)] slow down the code so much?
;;
;; UPDATE: it turns out that dotimes won't actually work through
;; lazy sequences unless you wrap the function in dorun also.
;; So the speedup was simply the lack of laziness. Laziness
;; has costs! Big ones!

;; execution
;; (print "1: ")(time (dotimes [n 10000] (sum-of-even-fibonaccis-below 4000000)));; -> "Elapsed time: ~11 msecs"
;; (print "2: ")(time (dotimes [n 10000] (sum-of-even-fibonaccis-below-2 4000000)));; -> "Elapsed time: ~6 msecs"
;; (print "3: ")(time (dotimes [n 10000] (sum-of-even-fibonaccis-below-3 4000000)));; -> "Elapsed time: ~95 msecs"
