(defproject scratch "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [clj-http "2.0.0"]
                 [com.walmartlabs/lacinia "0.17.0" :exclusions [clojure-future-spec]]
                 [ring/ring-core "1.6.0"]        
                 [ring-cors "0.1.10"]]
  :plugins [[lein-ring "0.12.0"]]
  :ring {:handler scratch.handler/app}
  :main ^:skip-aot scratch.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
