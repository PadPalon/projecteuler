(ns projecteuler)

(defn -main
  [filename]
  (load-file (str "src/problems/" filename ".clj"))
)