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

; ================================================================================

(defn attach-required-zeroes-at-begining [coll]  (into coll (repeat (- 4 (count coll ) ) 0)) )

; (def attach-required-zeroes ((repeat 0)(partial - 4 )))
(attach-required-zeroes-at-begining [2 3])

; ================================================================================

(def move-row-right (comp attach-required-zeroes-at-begining reverse remove-zeroes add-two-same-consecutive-number remove-zeroes))
(move-row-right '(2 2 4 2)) ;(0 4 4 2) (4 4 2 0)

; ================================================================================

(def move-row-left (comp reverse remove-zeroes add-two-same-consecutive-number remove-zeroes))

(move-row-left '(2 2 0 2))
; =========================================================================
(def move-grid-right
  "Moves an entire grid to the right"
  (partial map move-row-right)
)

;================================================================================

(def move-grid-left
  "Moves an entire grid to the left"
  (partial map move-row-right))


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