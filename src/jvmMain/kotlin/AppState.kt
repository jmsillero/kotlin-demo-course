import androidx.compose.runtime.mutableStateOf
import kotlin.concurrent.thread

object AppState {
    val state = mutableStateOf(
        UiState()
    )

    fun loadNotes() {
        thread {
            state.update { UiState(loading = true) }
            getNotes { state.value = UiState(it, false) }

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
