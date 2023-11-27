//Collectiopns

////inmutable list
data class Note(val title: String, val note: String)

val list: List<Note> = listOf(
    Note("Title 1", "Description 1"),
    Note("Title 2", "Description 2"),
    Note("Title 3", "Description 3"),
    Note("Title 4", "Description 4"),
    Note("Title 5", "Description 5")
)


val emptyList: List<Note> = emptyList()


val list2 = list + Note("Title 8", "Descripction8")
list2
list


//Mutable lists

val mutable : MutableList<Note> = mutableListOf(
    Note("Title 10", "Description 10"),
    Note("Title 20", "Description 20"),
    Note("Title 30", "Description 30"),
)
mutable.add(Note("Title 40", "Descripcion 40"))


//Sets inmutables

val setNotes = setOf<Note>(
    Note("Title 100", "Description 100"),
    Note("Title 200", "Description 200"),
    Note("Title 200", "Description 20"),
    Note("Title 200", "Description 200"),
)

setNotes

//Maps Inmutable...
val mapNotes = mapOf<Int, Note>(
   Pair(1, Note("Title 100", "Description 100")),
   Pair(2, Note("Title 200", "Description 200")),
   Pair(4, Note("Title 300", "Description 300")),
   Pair(5, Note("Title 400", "Description 400")),
)


mapNotes

//maps mutables
val mapMutNotes = mutableMapOf<Int, Note>(
    Pair(1, Note("Title 100", "Description 100")),
    Pair(2, Note("Title 200", "Description 200")),
    Pair(4, Note("Title 300", "Description 300")),
    Pair(5, Note("Title 400", "Description 400")),
)
mapMutNotes

mapMutNotes.put(8,  Note("Title 500", "Description 500"))

mapMutNotes

//most use
val mapTo = mapOf(
    1 to Note("Title 6", "Description 3"),
    2 to Note("Title 7", "Description 7"),
    3 to Note("Title 8", "Description 8"),
    4 to Note("Title 9", "Description 9")
)

mapTo



