(ns twenty48.core
  (:gen-class))


; " adding number at the beging of the list when that number is equal to the last element of the list "

(defn add-number-at-the-begining-of-the-list [coll num]
  (if (= (first coll) num)
    (conj (rest coll) (+ (first coll) num) 0)
    (conj coll num)
    )
  )


; ================================================================================

(def add-two-same-consecutive-number 
  (partial reduce add-number-at-the-begining-of-the-list '())
)
(add-two-same-consecutive-number '(2 4 4))
(add-two-same-consecutive-number '(8 4 4))
(add-two-same-consecutive-number '())

; ================================================================================

(def remove-zeroes (partial remove zero?))
(remove-zeroes '(0 2 2 4 0))

; appends zeroes to make count of the list to 4 at the begining
(defn append-required-zeroes-at-begining [coll]  (into coll (repeat (- 4 (count coll ) ) 0)) )

; appends zeroes to make count of the list to 4 at the end 
(def append-required-zeroes-at-the-end (comp append-required-zeroes-at-begining (partial apply vector)))

;Moves a row towards right 
(def move-row-right (comp append-required-zeroes-at-begining reverse remove-zeroes add-two-same-consecutive-number remove-zeroes))

;Moves a row towards left

(def move-row-left (comp append-required-zeroes-at-the-end reverse remove-zeroes add-two-same-consecutive-number remove-zeroes))
(move-row-left '(2 2 0 2))

; =========================================================================
(def move-grid-right
  "Moves an entire grid to the right"
  (partial map move-row-right)
)

;================================================================================

(def move-grid-left
  "Moves an entire grid to the left"
  (partial map move-row-left))


  (move-grid-left
    '((0 0 2 2)
      (0 2 0 4)
      (2 0 2 0)
      (0 4 4 0)))


(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)