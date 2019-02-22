(ns twenty48.core
  (:gen-class))

; adding number at the end of the list when that number is equal to the last element of the list

(defn add-number-at-the-end-of-the-list [coll num]
  (if (= (last coll) num)
    (concat (butlast coll) (list (+ (last coll) num)) (list 0))
    (concat coll (list num))))

; ================================================================================
(def add-two-same-consecutive-number 
  (partial reduce add-number-at-the-end-of-the-list '()))

; ================================================================================
(def remove-zeroes (partial remove zero?))

; appends zeroes to make count of the list to 4 at the begining
(defn append-required-zeroes-at-begining [coll]  (into coll (repeat (- 4 (count coll ) ) 0)) )

; appends zeroes to make count of the list to 4 at the end 
(def append-required-zeroes-at-the-end (comp (partial apply list) append-required-zeroes-at-begining (partial apply vector)))

;Moves a row towards right 
(def move-row-right (comp append-required-zeroes-at-begining remove-zeroes add-two-same-consecutive-number remove-zeroes))


;Moves a row towards left
(def move-row-left (comp append-required-zeroes-at-the-end remove-zeroes add-two-same-consecutive-number remove-zeroes))

; =========================================================================
(def move-grid-right
  "Moves an entire grid to the right"
  (partial map move-row-right)
)

;================================================================================

(def move-grid-left
  "Moves an entire grid to the left"
  (partial map move-row-left))

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)