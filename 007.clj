;; 10001st Prime
;; Problem 7
;;
;; By listing the first six prime numbers:
;;     2, 3, 5, 7, 11, and 13
;; we can see that the 6th prime is 13.
;;
;;
;; What is the 10,001st prime number?

;; (defn nth-prime [n]
;;   (defn prime? [n]
;;     (.isProbablePrime (biginteger n) 10))
;;   (defn primes [curr]
;;     (if (prime? curr)
;;       (lazy-seq (cons curr (primes (+ 2 curr))))
;;       (primes (+ 2 curr))))
;;   (nth (conj (primes 1) 2) (- n 1)))

;; This is a reformatted version of
;; Christophe's sieve!
;;
;; I'm moving to Go to work the rest
;; of this out, I think.
(defn nth-prime [n]
  (defn enqueue [sieve n step]
    (def m (+ n step))
    (if (sieve m)
      (recur sieve m step)
      (assoc sieve m step)))
  (defn next-sieve [sieve candidate]
    (if-let [step (sieve candidate)]
      (enqueue (dissoc sieve candidate) candidate step)
      (enqueue sieve candidate (+ candidate candidate))))
  (defn next-primes [sieve candidate]
    (if (sieve candidate)
      (next-primes (next-sieve sieve candidate) (+ candidate 2))
      (cons candidate
            (lazy-seq (next-primes (next-sieve sieve candidate)
                                   (+ candidate 2))))))
  (nth (cons 2 (lazy-seq (next-primes {} 3))) (- n 1)))

(print (time (nth-prime 10001)))
