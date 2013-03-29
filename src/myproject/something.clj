:keyword  // represents itself
'symbol   // refer to anohter thing
[] vectors
{ :key value } maps
#{} sets
'(1 2 3) lists

sequence infterface
first of a list or vector is the first
first of a sequence/map could be anything as they are unordered


ranges
(range 10)  (0 1 2 3 4 ... 9)

because range is first and the 'rest'
(take 5 (range))


lazy-seq ()  generate only when needed
wont blow the stack

ooperators in the first position mean you can hvae as many args as you want
(+ 10 8 2 3)


(fn [name]
  (println "Hello " name))

(def host "Thoughtworks") --- any data can be given a name, including functions

(def (fn [name] (println 1)))

(defn [name] (println "hello" 1))

(map inc [32 3 5])  inc is function passed to map
