(ns scratch.userapi
  (:require [scratch.core :refer [getCall]]
            [clojure.data.json :as json]))


(defn resolve-users [context args _value]
    (json/read-str (:body (getCall "http://private-339a33-user176.apiary-mock.com/users")) :key-fn keyword))

(defn resolve-user []
  (list))

(defn resolve-create-user! []
  (list))
