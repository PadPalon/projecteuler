(ns projecteuler.problems
  (:require clojure.set))

(defn getSetOfMultiples
  [x]
  (loop [iteration 1
         multiples #{}]
    (def multiple (* x iteration))
    (if (< multiple 1000)
      (recur (inc iteration) (conj multiples multiple))
      (identity multiples)
    )
  )
)

(defn getMultiples
  []
  (clojure.set/union (getSetOfMultiples 3) (getSetOfMultiples 5))
)

(println (reduce + (getMultiples)))
