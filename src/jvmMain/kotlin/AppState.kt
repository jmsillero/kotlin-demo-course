import androidx.compose.runtime.mutableStateOf
import kotlin.concurrent.thread

class AppState {
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
}
