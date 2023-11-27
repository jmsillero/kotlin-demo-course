//Properties delegates

class Database {
    fun save() {
        //
    }
}

class MyClass {
    //Create database object at the moment of create MyClass
    private val db = Database()

    fun save() {
        db.save()
    }
}


class MyClassWithDelegate {
    private val db by lazy { Database() }
    fun save() {
        db.save()
    }
}


val obj = MyClassWithDelegate()

//Create database object when call save functions
obj.save()


//Observable...
/*
 The value already exist
 */

class MyClassObs {
    var x: Int by Delegates.observable(0) { _, oldValue, newValue ->
        println("Old value: $oldValue,  new Value $newValue")
    }

    //Save value if the condition is true
    var positiveInt: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        newValue >= 0
    }

    //    late initialize NUllable, Double Int
    var lateInitialization: String by Delegates.notNull<String>()


    //Declare not null variable, without initialization
    lateinit var lateInitializacionValue: String
}

val observableObj = MyClassObs()
observableObj.x = 9
observableObj.x = 10


observableObj.positiveInt = 3
observableObj.positiveInt
observableObj.positiveInt = -8
observableObj.positiveInt

observableObj.positiveInt = 10
observableObj.positiveInt
observableObj.positiveInt = -2
observableObj.positiveInt
