(defproject scratch "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.0.0"]
                 [compojure "1.5.1"]
                 [cheshire "5.7.1"]
                 [hiccup "1.0.0"]]
  :plugins [[lein-ring "0.12.0"]
            [lein-exec "0.3.6"]]
  :ring {:handler scratch.core/app}
  :main ^:skip-aot scratch.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
