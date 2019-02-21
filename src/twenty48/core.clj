(ns twenty48.core
  (:gen-class))



  (def remove-zeroes (partial remove zero?))

  (defn add-when-equal [coll]
    (if (apply = coll)
      (list (apply + coll))
      coll
      )
    )

  
(defn move-grid-right
  "Moves an entire grid to the right"
  [grid]
  grid)

(defn move-grid-left
  "Moves an entire grid to the left"
  [grid]
  grid)

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)
