(require '[clojure.string :as s])

(defn find-prefix [trie prefix]
  (get trie prefix 0))

(defn add [map word]
  (reduce (fn [out current]
            (update out current #(if %1 (inc %1) 1)))
          map
          (rest (reductions str "" word))))

;; ------------------------------------------------

(require '[clojure.java.io :as io])
(def input (slurp (io/resource "input.txt")))

(time (let [lines (s/split-lines input)]
        (loop [trie {}
               [line & tail] lines]
          (if (nil? line) "finished"
                          (let [[op contact] (s/split line #" ")]
                            (case op
                              "add" (recur (add trie contact) tail)
                              "find" (do
                                       (println (find-prefix trie contact))
                                       (recur trie tail))))))))
