import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

data class Note(var id: Int, val title: String, val description: String, val type: Note.Type = Type.AUDIO) {
    enum class Type { TEXT, AUDIO }
}

suspend fun getNotes() = withContext(Dispatchers.IO) {
    // Thread.sleep(2000)
    delay(2000)

    (0..10).map {
        Note(it, "Title $it", "Descripcion $it", if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT)
    }

}
