enum class Shape {
    SQUARE, RECTABLE, CIRCLE, TRIANGLE
}

val shape = Shape.CIRCLE

shape.ordinal //position of value
shape

val shapes = Shape.values() // all values
shapes


//Value from String value
val newShape = Shape.valueOf("TRIANGLE")
newShape


//Enums with extras
enum class Color(val id: Int, val colorName: String) {
    RED(1, "red"), BLUE(2, "blue"), GREEN(3, "green"), BLACK(4, "black")
}

val color = Color.valueOf("BLUE")
color.ordinal
color.name
color.id


