//Objetcs


//NOTE: Objets load only after first use

object Database {
    private val items = mutableListOf<Int>()

    fun getAll(): List<Int> = items
    fun save(value: Int) {
        items.add(value)
    }
}


//Access to the object....

//Creating items
(0..5).forEach {
    Database.save(it)
}


//Getting items
val items = Database.getAll()
items



//Using interface
interface Callback {
    fun invoke()
}

fun foo(callback: Callback) {

}


foo(object : Callback {
    override fun invoke() {
        TODO("Not yet implemented")
    }
})
