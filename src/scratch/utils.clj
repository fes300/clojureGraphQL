(ns scratch.utils)

(defn numeric? [s]
  "returns true if the string can be safely parsed as string, false otherwise."
  (if-let [s (seq s)]
    (let [s (if (= (first s) \-) (next s) s)
          s (drop-while #(Character/isDigit %) s)
          s (if (= (first s) \.) (next s) s)
          s (drop-while #(Character/isDigit %) s)]
      (empty? s))))
