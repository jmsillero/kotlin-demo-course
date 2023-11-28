import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException

//Flow is sequential
fun main(): Unit =
    runBlocking {
        val res = flow {
            (0..8).forEach {
                delay(200)
                emit(it)
            }
        }.filter { it % 2 == 0 }
            .map { "Flow Res - Item $it" }

        val flow2 = flow {
            (0..10).forEach {
                emit(it)
            }
        }.transform {
            if (it % 2 == 0) emit("Flow2 - Item $it") else emit("Flow 2- I dont want to show the number")
        }


        launch {
            flow2.collect {
                println(it)
            }
        }

        launch {
            res.collect {
                //delay(500)
                println(it)
            }
        }


        val flowA = flowOf("A", "B", "C", "H").onEach { delay(300) }
        val flowB = flowOf("Z", "Y", "X").onEach { delay(500) }

        flowA.zip(flowB) { a, b -> "ZIP: $a -> $b" }
            .collect { println(it) } //emit a final value joining both flows If has a non pair, don't emit the value
        // print A-z B-Y C-X

        // emit one value from flowA and execute the function with the last emitted value in the flowB
        flowA.combine(flowB) { a, b -> "COMBINE: $a -> $b" }.collect { println(it) } //emit a final pair


//        Terminal operations

        /*
           .toList()
           .first()
           .reduce()
         */

        //Inside a flow we can not change the context....

        val flowX = flow {
            emit(3)
            throw IllegalStateException("Throwing exceptions")
        }

        //flowOn helps to change the context
        flowX
            .flowOn(Dispatchers.IO)
            .catch { throwable -> println(throwable.message) }
            .collect {
                println(it)
            }
    }
