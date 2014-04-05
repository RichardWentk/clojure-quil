(ns quil-sketches.rainbow-kiss
  (:use quil.core))

(def phase (atom 0))

(defn setup []
  (smooth)
  (stroke-weight 2)
  (color-mode :hsb 360 100 100 100))

(defn draw []
  (no-stroke)
  (fill 240 96 10)
  (rect 0 0 (width) (height))
  (no-fill)
  (push-matrix)
  (translate (/ (width) 2) (/ (height) 2))
  (doseq [y (map #(mod (+ (frame-count) %) (height)) (range 0 (height) 40))]
    (stroke (- (/ (height) 2) (/ y 2)) 100 100 100)
    (fill (- (/ (height) 2) (/ y 2)) 100 100 10)
    (rotate @phase)
    (swap! phase + 0.00005)
    (ellipse 0 0 (- (/ (width) 2) (- (height) y)) (- (height) y)))
  (pop-matrix))

(defsketch rainbow-kiss
  :title "rainbow-kiss"
  :setup setup
  :draw draw
  :size [1024 768])