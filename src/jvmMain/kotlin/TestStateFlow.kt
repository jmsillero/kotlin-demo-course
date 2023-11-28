import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class ViewModel {

    private val _state: MutableStateFlow<Note> = MutableStateFlow(Note(1, "Title 1", "Description", Note.Type.TEXT))
     val state: StateFlow<Note> = _state.asStateFlow()

    private val _stateShare  = MutableSharedFlow<Note>(replay = 2,  extraBufferCapacity = 3, onBufferOverflow = BufferOverflow.DROP_OLDEST) //Do not save the not collected values
    //replay - store count values
    // extraBufferCapacity
    // onBufferOverFlow - DROP_OLDERS --- remove older values


    val stateShare: SharedFlow<Note> = _stateShare.asSharedFlow()

    suspend fun update() {
        var count = 1
        while (true) {
            delay(40)
            count++
            _state.value = Note(count, "Title $count", "Description $count")
        }
    }


    suspend fun updateShareFlow() {
        var count = 1
        while (true) {
            delay(500)
            //Is suspended while is consumed
            _stateShare.emit(Note(count, "Title $count", "Description $count"))
            println("Emitting $count")
            count++
        }
    }
}

fun main() : Unit= runBlocking {
    val viewModel = ViewModel()
    launch {
        viewModel.update()
    }

    launch {
        viewModel.updateShareFlow()
    }
    delay(1000)
    viewModel.stateShare.collect{
        delay(2000)
        println(it)
    }

    viewModel.state.collect{
        println(it)
    }

}