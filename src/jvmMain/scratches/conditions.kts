//FLOWS controls...

val a = 90

if(a <= 80){
    println("Hello")
} else if(a > 50){
    println("World")
} else{
    println("New world")
}


//"if" can return a value
val result = if(a == 80) "Is 80" else "No is 80"
result

//when
val y = 90

when(y){
    in 0 .. 10 -> println("Value 1")
    in 20 .. 100 -> println("value 5")
    else -> println("No value")
}

//When can return a value like if

val otherResult = when(y){
    1, 2, 3 -> "Is less"
    10 -> "Decem"
    else -> "Large"
}

otherResult

//Check type

val ttt : Number = 0.9f

val type = when(ttt){
    is Int -> "Integer"
    is Float -> "Float"
    is Double -> "Double"
    else -> "No value"
}

type

// When without param
val res = when{
    y < 70 -> "Minor"
    y > 89 -> "Bigger"
    else -> "No value"
}
res

//Bucles
data class Note(val title: String, val note: String)

val list: List<Note> = listOf(
    Note("Title 1", "Description 1"),
    Note("Title 2", "Description 2"),
    Note("Title 3", "Description 3"),
    Note("Title 4", "Description 4"),
    Note("Title 5", "Description 5")
)


//Iterate by indices....
for (i in list.indices){
    println("Index $i")
}

//For is most efficient than foreach inside the list
