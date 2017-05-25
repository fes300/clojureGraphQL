(ns scratch.core
  (:gen-class)
  (:use compojure.core
        [hiccup.middleware :only (wrap-base-url)]
        [hiccup core page])
  (:require [scratch.utils :as utils]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]
            [clj-http.client :as client]
            [cheshire.core :refer :all]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn getCall 
  [url]
  (client/get url {:as :json}))

(->> (:body
       (getCall "http://private-339a33-user176.apiary-mock.com/users"))
     (def users))

(defn index-page []
  (html5
    [:head
      [:title "Hello World"]
      (include-css "/css/style.css")]
    [:body
      [:h1 "Hello World"]]))

(defn user [id]
  "returns the user with the specified id"
  (if
    (utils/numeric? id)
    (str (nth users (read-string id)))
    "id must be a number"))

(defroutes main-routes
  (GET "/" [] (index-page))
  (GET "/user" [id] (user id))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> (handler/site main-routes)
      (wrap-base-url)))
