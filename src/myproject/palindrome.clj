(ns myproject.palindrome
  (:require clojure.contrib.generic.math-functions))

(defn digits [num]
  range (expt 10 num)
)