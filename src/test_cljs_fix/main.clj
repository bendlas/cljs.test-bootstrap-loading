(ns test-cljs-fix.main
  (:require
   [ring.util.response :refer [redirect]]
   [ring.middleware.resource :refer [wrap-resource]]))

(def handler
  (-> (fn [{:keys [uri]}]
        (println uri)
        (when (= "/" uri)
          (redirect "/index.html")))
      (wrap-resource "www")))

