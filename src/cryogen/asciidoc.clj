(ns cryogen.asciidoc
  (:require [cryogen-core.markup :refer [rewrite-hrefs markup-registry]]
            [clojure.string :as s])
    (:import org.asciidoctor.Asciidoctor$Factory
             org.asciidoctor.Options
             org.asciidoctor.SafeMode
             java.util.Collections
             cryogen_core.markup.Markup))

(def ^:private ^:static adoc (Asciidoctor$Factory/create))

(defn asciidoc
  "Returns an Asciidoc (http://asciidoc.org/) implementation of the
   Markup protocol."
   []
   (reify Markup
     (dir [this] "asc")
     (ext [this] ".asc")
     (render-fn [this]
       (fn [rdr config]
         (println "config: " config)
         (->> 
           (.convert adoc
                (->> (java.io.BufferedReader. rdr)
                     (line-seq)
                     (s/join "\n"))
                {Options/SAFE (int 1)}
                #_{Options/SAFE SafeMode/SAFE}
                #_{"safe" (int 1)}
                #_(Collections/emptyMap))
           (rewrite-hrefs (:blog-prefix config)))))))

(defn init []
  (swap! markup-registry conj (asciidoc)))
