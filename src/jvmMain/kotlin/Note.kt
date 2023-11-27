data class Note(var id: Int, val title: String, val description: String, val type: Note.Type = Type.AUDIO) {
    enum class Type { TEXT, AUDIO }
}

fun getNotes(callback: (List<Note>) -> Unit) {
    Thread.sleep(2000)
    callback((0..10).map {
        Note(it, "Title $it", "Descripcion $it", if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT)
    })

}
