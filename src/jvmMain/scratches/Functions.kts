// (A,B) -> C
// (Params) -> return type

val f: (Int, Int) -> Int = { x, y -> x + y }

f(6, 7)

//Also we can do

val fn = { x: Int, y: Int -> x * y }
fn(10, 5)

//pass a function as argument
fun doOperation(a: Int, b: Int, operation: (Int, Int) -> Int) = operation(a, b)

doOperation(5, 4, f)


doOperation(8, 7) { x, y ->
    x * y
}

//Extension

val str = "Hello"

fun String.take3FirstCharacters() = this.take(3)

"HelloWorld".take3FirstCharacters()


//Scope functions...
val strBuilder = StringBuilder()

strBuilder.append("Hello")
strBuilder.append(" ")
strBuilder.append("World!!!!")

val str1 = strBuilder.toString()

//Using WITH (return the last expresion value)
val res23 = with(StringBuilder()) {
    append("Hello")
    append(" ")
    append("World!!!")
    toString()
}

res23


//Most useful when I want to return a value
val newRes = StringBuilder().run {
    append("Hello")
    append(" ")
    append("World!!!")
    toString()
}

newRes

//IF I want to return the configured object
val strB = StringBuilder().apply {
    append("Hello")
    append(" ")
    append("World!!!")
}

strB


//Use let for checking null values

//also do additional operations with the same objet.
val variableStr: String? = null
variableStr?.take(2)?.reversed()?.let(::op)
    .also(::println)


fun op(str: String) {
    //Do an operation
}