; Copied from https://github.com/logseq/nbb-logseq/blob/main/examples/query.cljs
(ns query
  "Script that queries a local graph with given query"
  (:require ["fs" :as fs]
            ["path" :as path]
            ["os" :as os]
            [datascript.transit :as dt]
            [datascript.core :as d]
            [clojure.pprint :as pprint]
            [clojure.edn :as edn]
            [nbb.core :as nbb]
            [deps]
            [logseq.db.rules :as rules]
            ; This has tons of requires unfortunately
            ; [query_dsl :as q]
            )
  (:refer-clojure :exclude [exists?]))

;; fs utils
(defn expand-home
  [path]
  (path/join (os/homedir) path))

(defn entries
  [dir]
  (fs/readdirSync dir))

(defn slurp
  [file]
  (fs/readFileSync file))

(defn exists?
  [file]
  (fs/existsSync file))

(defn directory?
  [file]
  (.isDirectory (fs/lstatSync file)))

;; graph utils
(defn get-graph-paths
  []
  (let [dir (expand-home ".logseq/graphs")]
    (->> (entries dir)
         (filter #(re-find #".transit$" %))
         (map #(str dir "/" %)))))

(defn full-path->graph
  [path]
  (second (re-find #"\+\+([^\+]+).transit$" path)))

(defn get-graph-path
  [graph]
  (some #(when (= graph (full-path->graph %)) %)
        (get-graph-paths)))

(defn- get-graph-db
  [graph]
  (when-let [file (or (get-graph-path graph)
                      ;; graph is a path
                      graph)]
    (when (exists? file)
      (-> file slurp dt/read-transit-str))))

; (def graph-name "publishing-with-logseq")

(defn -main
  [args]
  (if-not (= 2 (count args))
    (println "Usage: $0 GRAPH QUERY")
    ; (println "Usage: $0 QUERY")
    ; Breaking this into nested (let) forms, so I can print the parsed query
    (let [[graph-name query] args
          ; [query] args
          db (or (get-graph-db graph-name)
                 (throw (ex-info "No graph found" {:graph graph-name})))
          query' (edn/read-string query)]
      (pprint/pprint query')
      (let [results (map first (d/q query' db))]
        (pprint/pprint results)))))

(when (= nbb/*file* (:file (meta #'-main)))
  (-main *command-line-args*))
