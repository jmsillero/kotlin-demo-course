import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.concurrent.thread

object AppState {
    var state by mutableStateOf(UiState())

    fun loadNotes() {
        thread {
            state = UiState(loading = true)
            getNotes { state = UiState(it, false) }

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
