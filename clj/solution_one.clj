(require '[clojure.string :as s]);

(defn find-prefix [trie prefix]
  (:counter (get-in trie (s/split prefix #"")) 0))

(defn add [trie word]
  (reduce (fn [out current]
            (update-in out (concat (s/split current #"") [:counter]) #(if %1 (inc %1) 1)))
          trie
          (rest (reductions str "" word))))

;; ---------------------------------------------------------

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

