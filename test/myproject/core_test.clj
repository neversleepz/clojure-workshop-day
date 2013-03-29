(ns myproject.core-test
  (:use clojure.test
        myproject.core))

(deftest naturals
  (testing "All naturals below 10"
    (is (= (naturals1to9) (list 1 2 3 4 5 6 7 8 9)))))


(deftest mult3or5
  (testing "Multiples 3"
    (is (and (map mult3 (list 3 6 9) ))))
  (testing "Multiples 5"
    (is (and (map mult5 (list 5 10 15)))))
  (testing "Multiple 3 or 5"
    (is (and (map mult3or5 (list 5 3 6 9 10 15 25 27)))))
)