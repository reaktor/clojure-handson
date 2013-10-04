(ns clojure-handson.exercises)

;; To make this file as instarepl, press CTRL + space and type 'make',
;; select 'Make current editor an instarepl

(def my-seq '(1 2 3 4 5))

;; Write an expression which returns the last element in a sequence.
;; With restriction to not to use function last
;;
;; (= 5 _)

;; Write a function which returns the second to last element from a sequence.
;;
;; (= 4 _)



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

;; How to get numeric value from character:

(defn as-int [char]
  (Character/getNumericValue char))

















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

;; (= {:suit :diamond :rank 10} (_ "DQ"))
;; (= {:suit :heart   :rank 3}  (_ "H5"))
;; (= {:suit :club    :rank 12} (_ "CA"))
;; (= (range 13) (map (comp :rank _ str)
;;                   '[S2 S3 S4 S5 S6 S7
;;                     S8 S9 ST SJ SQ SK SA]))



;; Write a function that does math using the infix notation.
;; It accepts a variable length mathematical expression consisting
;; of numbers and the operations +, -, *, and /.
;; Assume a simple calculator that does not do precedence and instead
;; just calculates left to right.

;; (= 7  (_ 2 + 5))
;; (= 42 (_ 38 + 48 - 2 / 2))
;; (= 8  (_ 10 / 2 - 1 * 2))
;; (= 72 (_ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))
