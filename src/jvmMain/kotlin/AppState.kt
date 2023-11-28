import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext

object AppState {
    var state by mutableStateOf(UiState())

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            state = UiState(loading = true)
            state = UiState(notes = getNotes())
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )

    //Companion objet, is like static functions or values
    //We can only create a companion object per class
//    companion object MyObjectName {
//        fun foo() {
//            println("Im a companion obj")
//        }
//    }
}
