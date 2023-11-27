val x = 30  //immutable variables

//explicit
//val y : Int = 40

var t = 50
t = 90

val a : Long = 90

val y = a.toInt()


//Functions...
fun sumVoid(x: Int, y : Int){
    val a = x + y
}

sumVoid(4, 5)

fun sum(x: Int, y : Int): Int{
    return   x + y
}

sum(4,5)


// classes
open class Person(name: String){
    var name = name
        get() = "Hello $field"
        set(value ) {
            if(value != field){
                field = "$value Nombre raro"
            }
        }
}
val person = Person("Utulakaka")

person.name = "Pratukuruku"

person.name

interface  CanWalk{
    fun doStep()

    fun walk(step: Int){
        repeat(step){doStep()}
    }
}

class Dog : CanWalk{
    override fun doStep() {

    }
}

val dog = Dog()
dog.walk(67)

//CHEEEECKKK.....

val p1 = Person("JM")
val p2 = Person("JM")

p1 == p2  // FLASE

p1.toString() // No timplemented


data class Pers(val name : String, val age: Int = 90)

val per1 = Pers("Hello")
val per2 = Pers("Hello")

per1 == per2 // TRUE
per1 === per2 // FALSE

val per3 = per1
per3 === per1 // TRUE

per1.toString()

//DESTRUCTURING
val per4 = Pers("Pepe", 90)
val (_, b1) = per1
val (f1, h1) = per4