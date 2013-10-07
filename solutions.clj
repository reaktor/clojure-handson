(ns my.solutions)

(def my-seq '(1 2 3 4 5))
(def venue {:year 2013 :name "DevDay"
            :program {:sessions 9 :keynotes 3 :hands-ons 3}})

;; Write a function which returns the last element in a sequence,
;; with restriction to not to use function last

(= 5 (first (reverse my-seq)))


;; Write a function which returns the second to last element from a sequence.

(= 4 (second (reverse my-seq)))
;; or
(= 4 ((comp peek pop vec) s))


;; When given 500 character length string of numbers,
;; find the maximum value when multiplying five consecutive numbers

;; (= 34992 (_ numbers-in-string))

(def numbers-in-string (str "37900490610897696126265185408732594047834333441947"
                            "01850393807417064181700348379116686008018966949867"
                            "75587222482716536850061657037580780205386629145841"
                            "06964490601037178417735301109842904952970798120105"
                            "47016802197685547844962006690576894353336688823830"
                            "22913337214734911490555218134123051689058329294117"
                            "83011983450277211542535458190375258738804563705619"
                            "55277740874464155295278944953199015261800156422805"
                            "72771774460964310684699893055144451845092626359982"
                            "79063901081322647763278370447051079759349248247518"))

(defn as-int [char]
  (Character/getNumericValue char))

(defn max-of-5-multiply [s]
  (->> (seq s)
     (map as-int)
     (partition 5 1)
     (map #(reduce * %))
     (apply max)))

(= 34992 (max-of-5-multiply numbers-in-string))



;; A standard deck of playing cards has four suits -
;; spades, hearts, diamonds, and clubs - and thirteen cards in each suit.
;; Two is the lowest rank, followed by other integers up to ten;
;; then the jack, queen, king, and ace.

;; It's convenient for humans to represent these cards as suit/rank pairs,
;; such as H5 or DQ: the heart five and diamond queen respectively.
;; But these forms are not convenient for programmers, so to write a card
;; game you need some way to parse an input string into meaningful components.
;; For purposes of determining rank, we will define the cards to be valued
;; from 0 (the two) to 12 (the ace)

;; Write a function which converts (for example) the string "SJ"
;; into a map of {:suit :spade, :rank 9}. A ten will always be represented
;; with the single character "T", rather than the two characters "10".

(defn as-rank-map [[s r]]
  {:suit (get {\S :spade \H :heart \D :diamond \C :club} s)
   :rank (.indexOf (seq "23456789TJQKA") r)})

(= {:suit :diamond :rank 10} (as-rank-map "DQ"))
(= {:suit :heart :rank 3} (as-rank-map "H5"))
(= {:suit :club :rank 12} (as-rank-map "CA"))
(= (range 13) (map (comp :rank as-rank-map str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA]))


;; Write a function that does math using the infix notation. Write a function
;; that accepts a variable length mathematical expression consisting of numbers
;; and the operations +, -, *, and /. Assume a simple calculator that does not
;; do precedence and instead just calculates left to right.

(defn calculator [& xs]
  (loop [res (first xs) ops (rest xs)]
    (if (empty? ops)
      res
      (recur ((first ops) res (second ops))
             (rest (rest ops))))))

(= 7  (calculator 2 + 5))
(= 42 (calculator 38 + 48 - 2 / 2))
(= 8  (calculator 10 / 2 - 1 * 2))
(= 72 (calculator 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))




;; Implement keys and vals with map

(= (map first venue) (keys venue))
(= (map second venue) (vals venue))


;; Update venue to last year

(= (assoc venue :year 2012)
   {:year 2012 :name "DevDay"
    :program {:sessions 9 :keynotes 3 :hands-ons 3}})
;; or
(= (update-in venue [:year] dec)
   {:year 2012 :name "DevDay"
    :program {:sessions 9 :keynotes 3 :hands-ons 3}})


;; Update venue to have one more hands-on

(= (update-in venue [:program :hands-ons] inc)
   {:year 2013 :name "DevDay"
    :program {:sessions 9 :keynotes 3 :hands-ons 4}})


;; Update venue to have also five breaks and one lunch
(= (update-in venue [:program] #(assoc % :breaks 5 :lunches 1))
   {:year 2013 :name "DevDay"
    :program {:lunches 1 :breaks 5 :sessions 9 :keynotes 3 :hands-ons 3}})

