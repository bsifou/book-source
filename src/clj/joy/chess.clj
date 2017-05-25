(ns joy.chess)

(defn initial-board []
  [\r \n \b \q \k \b \n \r
   \p \p \p \p \p \p \p \p
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \P \P \P \P \P \P \P \P
   \R \N \B \Q \K \B \N \R])



(def ^:dynamic *file-key* \a)
(def ^:dynamic *rank-key* \0)

;; namespace encapsulation
(defn- file-component [file]
  (- (int file) (int *file-key*)))

(defn- rank-component [rank]
  (->> (int *rank-key*)
       (- (int rank))
       (- 8)
       (* 8)))

(defn- index [file rank]
  (+ (file-component file) (rank-component rank)))

(defn lookup [board pos]
  (let [[file rank] pos]
    (board (index file rank))))

;; closure encapsulation
(letfn [(index [[file rank]]
          (let [f (- (int file) (int \a))
                r (* 8 (- 8 (- (int rank) (int \0))))]
            (+ f r)))]
  (defn lookup2 [board pos]
    (board (index pos))))



;; local encapsulation (most specific scope)

(defn lookup3 [board [file rank]]
  (let [f (- (int file) (int \a))
        r (* 8 (- 8 (- (int rank) (int \0))))
        index (+ f r)]
    (board index)))



;; (lookup (initial-board) "a8")
;;=> \r











