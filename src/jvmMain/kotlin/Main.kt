import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun App(appState: AppState) {

    if (appState.state.value.notes == null) {

        LaunchedEffect(true) {
            appState.loadNotes()
        }
    }

    val items = appState.state.value.notes
    MaterialTheme {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            if (appState.state.value.loading) {
                CircularProgressIndicator()
            } else {
                appState.state.value.notes?.let {
                    NotesList(it)
                }
            }
        }
    }
}

@Composable
fun NotesList(items: List<Note>) {
    LazyColumn(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        items(items) { note ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text(note.title, style = MaterialTheme.typography.h6)
                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(note.description)
                }
            }
        }
    }
}

fun main() {
    val appState = AppState()
    application {

        Window(onCloseRequest = ::exitApplication) {
            App(appState)
        }
    }
}