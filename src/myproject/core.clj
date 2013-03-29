(ns clojure-workshop-day.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn naturals1to9 []
  (rest (range 10))
)

(defn mult3 [number]
  (= 0 (mod number 3)))

(defn mult5 [number]
  (= 0 (mod number 5)))

(defn mult35 [number] 
  (or (mult3 number) (mult5 number)))

(defn numbsbelowThatAreMultiples []
  (filter mult35 (rest(range 1000))))

(defn numbsbelow10ThatAreMultiples []
  (filter mult35 (naturals1to9)))

(defn summults35below10 [] 
  (reduce + (numbsbelowThatAreMultiples)))

(defn fibbase []
  (cons 1 2)
)

(defn positive-numbers
    ([] (positive-numbers 1))
    ([n] (cons n (lazy-seq (positive-numbers (inc n))))))

(defn sum-last-2 
  ([] (sum-last-2 1 2))
  ([n m] (cons n (lazy-seq (sum-last-2 m (+ n m)))))
)


 (defn fib [a b] (cons a (lazy-seq (fib b (+ b a)))))

(defn fibwhen [filter] 
    (take-while filter (fib 1 2))
)


