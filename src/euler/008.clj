(ns euler.008)

;; first implementation
;; kinda slow :-(
;;
;; (defn largest-product-in-series [l n]
;;   (let [s (map read-string (map str (seq n)))
;;         cap (- (count n) l)]
;;     (loop [i 0
;;            product 0]
;;       (if (< i cap)
;;         (recur (+ 1 i) (max (reduce * (take l (drop i s))) product))
;;         product))))

;; second try
;; better!
(defn largest-product-in-series [l n]
  (reduce max (map #(reduce * %) (partition-all l 1 (map read-string (map str (seq n)))))))
