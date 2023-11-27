import androidx.compose.runtime.MutableState

//Function extension
fun <T> MutableState<T>.update(produceValue: () -> T) {
    this.value = produceValue()
}
