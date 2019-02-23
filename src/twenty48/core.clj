(ns twenty48.core
  (:gen-class))

; adding number at the end of the list when that number is equal to the last element of the list
(defn add-number-at-the-begining-of-the-list [coll num]
  (if (= (first coll) num)
    (conj (rest coll) (+ (first coll) num) 0)
    (conj coll num)))

;add consecutive numbers in given lists
(def add-two-same-consecutive-number (comp (partial reduce add-number-at-the-begining-of-the-list '()) reverse))

;Removes all zeroes
(def remove-zeroes (partial remove zero?))

; appends zeroes to make count of the list to 4 at the begining
(defn append-required-zeroes-at-begining [coll]  (into coll (repeat (- 4 (count coll ) ) 0)) )

; appends zeroes to make count of the list to 4 at the end 
(def append-required-zeroes-at-the-end (comp (partial apply list) append-required-zeroes-at-begining (partial apply vector)))

;Moves a row towards right 
(def move-row-right (comp append-required-zeroes-at-begining remove-zeroes add-two-same-consecutive-number remove-zeroes))

;Moves a row towards left
(def move-row-left (comp append-required-zeroes-at-the-end reverse remove-zeroes add-two-same-consecutive-number reverse remove-zeroes ))

;transpose the gives lists
(def transpose-grid (partial apply map list))

;"Moves an entire grid to the right"
(def move-grid-right (partial map move-row-right) )

;"Moves an entire grid to the left"
(def move-grid-left (partial map move-row-left))

;"Moves an entire grid down"
(def move-grid-down (comp transpose-grid move-grid-right transpose-grid))

;"Moves an entire grid up"
(def move-grid-up (comp transpose-grid move-grid-left transpose-grid))