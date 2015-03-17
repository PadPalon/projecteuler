(ns problems.third
  (:require [clojure.math.numeric-tower :as math]))

(defn isPrime
  [x]
  (let [testTo (math/ceil (math/sqrt x))]
    (loop [iteration 2]
      (if (>= iteration testTo)
        true
	      (if (= 0 (mod x iteration))
	        false
	        (recur (inc iteration))
		      )
	      )
	    )
	  )
  )

(defn getNextPrimeNumber
  [x]
  (loop [number (inc x)]
    (if (isPrime number)
      number
      (recur (inc number))
      )
    )
  )

(defn getHighestPrimeFactor
  [x]
  (loop [primefactor 2
         number x]
    (if (= number primefactor)
      number
      (let [dividend (/ number primefactor)]
	      (if (ratio? dividend)
	        (recur (getNextPrimeNumber primefactor) number)
	        (recur 2 dividend)
	        )
	      )
      )
    )
  )

(println (getHighestPrimeFactor 600851475143))
          