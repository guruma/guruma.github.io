(ns cryogen.core
  (:require [cryogen-core.compiler :refer [compile-assets-timed]]
            [cryogen-core.plugins :refer [load-plugins]]
            [cryogen.asciidoc :refer [init]]))

(defn -main []
  ;(load-plugins)
  (init)
  (compile-assets-timed)
  (System/exit 0))
