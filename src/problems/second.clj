(ns problems.second)

(defn getFibonacciNumbers
  []
  (loop [first 0
         second 1
         evenNumbers []]
    (def sum (+ first second))
    (if (< sum 4000000)
      (if (even? sum)
        (recur second sum (conj evenNumbers sum))
        (recur second sum (identity evenNumbers))
      )
      (identity evenNumbers)
    )
  )
)

(println (reduce + (getFibonacciNumbers)))
 