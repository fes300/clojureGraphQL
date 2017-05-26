(ns scratch.schema
  (:require                    
   [scratch.user-api :as db] 
   [clojure.java.io :as io]    
   [clojure.edn :as edn]       
   [com.walmartlabs.lacinia.schema :as schema]
   [com.walmartlabs.lacinia.util :refer [attach-resolvers]]))
    
(defn user-schema       
  []
  (-> (io/resource "resources/edn/user-schema.edn")
      slurp                    
      edn/read-string          
      (attach-resolvers {:resolve-user db/resolve-user
                         :resolve-users db/resolve-users 
                         :resolve-create-user! db/resolve-create-user!})
      schema/compile))
