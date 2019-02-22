(ns twenty48.core-test
  (:require [clojure.test :refer :all]
            [twenty48.core :refer :all]))

(deftest adding-number-at-the-beging-of-the-list 
  (testing " adding number at the beging of the list when that number is equal to the last element of the list "
    (is (= '(0 4 2 3)
            (add-number-at-the-begining-of-the-list 
              '(2 2 3) 2) )
    )
    (is (= '(3 2 2 3)
            (add-number-at-the-begining-of-the-list 
              '(2 2 3) 3 ))
    )
    (is (= '(3)
            (add-number-at-the-begining-of-the-list 
            '() 3))
    )
  )
)

(deftest moving-grid-right
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 4)
             (0 0 2 4)
             (0 0 0 4)
             (0 0 0 8))
           (move-grid-right
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-left
  (testing "rows with numbers that repeat"
    (is (= '((4 0 0 0)
             (2 4 0 0)
             (4 0 0 0)
             (8 0 0 0))
           (move-grid-left
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-up
  (testing "rows with numbers that repeat"
    (is (= '((2 2 4 2)
             (0 4 4 4)
             (0 0 0 0)
             (0 0 0 0))
           (move-grid-up
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-down
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 0)
             (0 0 0 0)
             (0 2 4 2)
             (2 4 4 4))
           (move-grid-down
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))
