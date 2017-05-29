;; added

(ns joy.zippers
  (:require [clojure.zip :as z] ))


(zipper
 vector?                                ; branch
 seq                                    ;how to get the children?
 (fn [node children]
   (with-meta (vec children) (meta node))))


(comment

  location -> node & path (all sotred as vector)
  path has right, r, parent, path

  node

)

(zipper seq? identity
        (fn [node children] ))



;; tree editing api, purely functional.

(def data [1
           [2 3 4]
           [[5 6]
            [7 8]
            [[9 10 11]]]
           12])


(-> (z/vector-zip data)
    (z/down)
    )


(def clueless 9)

(class clueless)

(class (+ 9 0.1))

(unchecked-add Long/MAX_VALUE Long/MAX_VALUE)

(let [s 0.0000000000000000000000000000000000000000000000000000001]
  (class s)
  s)

(class 0.1M)

(def a1 1.0e50)
(def a2 -1.0e50)


;; keyword act as directive 
(def pour [de jusqua]
  (cond (= jusqua :toujours)  (iterate inc de))
  :else (range de jusqua))

