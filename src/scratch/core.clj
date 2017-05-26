(ns scratch.core
  (:require [clj-http.client :as client]
            [clojure.string :as string]))

(defn getCall 
  [url]
  (client/get url {:as :json}))

(defn numeric? [s]
  "returns true if the string can be safely parsed as string, false otherwise."
  (if-let [s (seq s)]
    (let [s (if (= (first s) \-) (next s) s)
          s (drop-while #(Character/isDigit %) s)
          s (if (= (first s) \.) (next s) s)
          s (drop-while #(Character/isDigit %) s)]
      (empty? s))))

(defn uuid [] (string/replace (str (java.util.UUID/randomUUID)) #"-" ""))

;(defn user [id]
  ;"returns the user with the specified id"
  ;(if
    ;(numeric? id)
    ;(str (nth users (read-string id)))
    ;"id must be a number"))


