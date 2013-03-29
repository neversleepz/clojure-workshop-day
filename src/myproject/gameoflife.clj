(ns clojure-workshop-day.gameoflife
    (:require [clojure.set :as cs :refer [difference union intersection]])
)

(defn less2 [num]
  (< num 2)
)

(defn twoTo3 [num]
  (and (> num 1) (< num 4))
  )

(defn more3 [num]
  (> num 3))

(defn exactly3 [num]
  (= num 3))

(defn neighbours [x y]
  [
     [(dec x) (dec y)]  [x (dec y)]  [(inc x) (dec y)] 
     [(dec x) y]                     [(inc x) y]
     [(dec x) (inc y)]  [x (inc y)]  [(inc x) (inc y)]
   ]
  )


(defn game-of-life [game]
  (rules game)
)

(def initcells [[1 2] [2 2] [3 2]])

(defn all-neighbours [[x y]]
  (neighbours x y))

(defn findlive [cell cells]
  (intersection (set (all-neighbours cell))
                (set cells)
  )
)

(defn countlive [cell cells]
  (count (findlive cell cells))
  )

(defn killcells [livecells]
  (remove (fn[x] 
            (let [c (countlive x livecells)]
             (or 
              (less2 c)
              (more3 c)
             )
            ))
            livecells)
)

(defn keepcells [livecells]
  (filter (fn[x]
             (twoTo3 (countlive x livecells))) livecells))

(defn revivecells [livecells]
  (filter (fn[x] (exactly3 (countlive x livecells))) (finddead livecells))
)
  
(defn finddead [livecells]
   (difference (set (reduce union (map all-neighbours livecells))) livecells)
)

(defn rules [livecells] (set (union 
                  (killcells livecells) 
                  (keepcells livecells) 
                  (revivecells livecells))))