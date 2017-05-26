(ns scratch.user-api
  (:require [scratch.core :refer [getCall]]))


(defn resolve-users []
  (:body
    (getCall "http://private-339a33-user176.apiary-mock.com/users")))


(defn resolve-user []
  (list))

(defn resolve-create-user! []
  (list))
