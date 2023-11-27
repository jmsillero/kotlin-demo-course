//Ranges

//Range 0 to 10
//Open left .. open right
(0 .. 10).map {
    "Item $it"
}


(0 .. 10 step 2).map { "Item $it" }


//Inverse range
(10 downTo  0).map {
    "Item $it"
}


//Not included last item
(0 until 10).map { "Item $it" }

//Character ranges
('a' .. 'h').map { "Letter $it" }


//Check ranges...
val value = 0.9f
(0.0 .. 1.0)

value in (0.0 .. 1.0) // value is between 0.0 and 1.0


//Ranges could be used in Bucles..