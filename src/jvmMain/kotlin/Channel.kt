import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//Only emit a new value if the previous value is consumed
//capacity param modify the values amount
class ViewModelChannel {

    private val _state: Channel<Note> = Channel<Note>(capacity = Channel.BUFFERED)
    val state = _state//.receiveAsFlow()


    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun update() {
        var count = 1
        while (!_state.isClosedForSend) {
            delay(500)
            _state.send(Note(count, "Title $count", "Description $count"))
            println("Emitting  $count")
            count++

            if(count > 10){
                _state.close()
            }

        }
    }


}

fun main(): Unit = runBlocking {
    val viewModel = ViewModelChannel()
    launch {
        viewModel.update()
    }

    delay(1000)

    for (state in viewModel.state){
        delay(1000)
        println(state)
    }

//    viewModel.state.for {
//        delay(1000)
//        println(it)
//    }

}