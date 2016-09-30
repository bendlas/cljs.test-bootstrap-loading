(defproject test-cljs-fix "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha13"]
                 [org.clojure/clojurescript "1.9.229"]
                 ;; [binaryage/dirac "0.6.7"]
                 [ring "1.5.0"]]

  :resource-paths ["target/gen-resources" "resources"]

  :ring {:handler test-cljs-fix.main/handler
         :adapter {:port 8080}
         :nrepl {:start? true :port 5010}}
  
  :cljsbuild {:builds
              [{:id "devel"
                :source-paths ["src"]
                :compiler {:main test-cljs-fix.main
                           :preloads [
                                      ;; dirac.runtime.preload
                                      test-cljs-fix.preload
                                      ]
                           :output-to "target/gen-resources/www/devel-cljs/devel.js"
                           :output-dir "target/gen-resources/www/devel-cljs"
                           :asset-path "/devel-cljs"
                           :source-map "target/gen-resources/www/devel-cljs/devel.js.map"
                           :source-map-timestamp false}}]}
  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-ring "0.9.7"]])
