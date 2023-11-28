import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

//Flows...

val res = flowOf(1, 2, 3, 4)
res


val listAsFlow = listOf(4,5,7,89,9).asFlow()

listAsFlow


val newFlow = flow {
    emit(1)
    emit(2)
    emit(3)
    emit(4)
    emit(5)
}

newFlow