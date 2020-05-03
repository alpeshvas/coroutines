import kotlinx.coroutines.*

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("In default dispatcher: thread name: ${Thread.currentThread().name}")
            delay(3000L)
            println("In default dispatcher completed: thread name: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("In IO dispatcher: thread name: ${Thread.currentThread().name}")
            delay(3000L)
            println("In IO dispatcher completed: thread name: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("In Unconfined dispatcher: thread name: ${Thread.currentThread().name}")
            delay(3000L)
            println("In Unconfined dispatcher completed: thread name: ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("NewThread everytime")) {
            println("In newSingleThreadContext dispatcher: thread name: ${Thread.currentThread().name}")
            delay(3000L)
            println("In newSingleThreadContext dispatcher completed: thread name: ${Thread.currentThread().name}")
        }
    }
}