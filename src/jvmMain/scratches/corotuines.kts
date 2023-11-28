import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


data class User(val user: String, val pass: String, val friends: List<User> = listOf())

class UserService {
    suspend fun doLogin(user: String, pass: String) = withContext(Dispatchers.IO) {
        User(user, pass)
    }

    suspend fun requestCurrentFriend(user: User) = withContext(Dispatchers.IO) {
        (0..10).map { User("$it user", "pass $it") }.toList()
    }

    suspend fun requestSuggestedFriend(user: User) = withContext(Dispatchers.IO) {
        (0..10).map { User("$it Suggested", "pass $it") }.toList()
    }

}


fun test() {
    val userService = UserService()

    //coroutine scope
    val cScope = object: CoroutineScope{
        val job =  SupervisorJob()//Supervisor Job most useful por UI

        //Job() if it's fails all coroutines will be cancelled


        override val coroutineContext: CoroutineContext
            get() = Dispatchers.Main + job

    }

    //User main scope for Main Thread
    val mainCoroutineScope = MainScope()

    //Return a job
    mainCoroutineScope.launch(Dispatchers.Main) {
        println("Starting")
        val user = userService.doLogin("Hola", "Mundo")

        val currentFriends = userService.requestCurrentFriend(user)

        //start in parallel
        val suggestedFriends = async { userService.requestSuggestedFriend(user) }


        val finalUser = user.copy(friends = currentFriends + suggestedFriends.await())
        println(finalUser)
    }

    //cScope.job.cancel()
    mainCoroutineScope.coroutineContext.job.cancel()

}

test()

