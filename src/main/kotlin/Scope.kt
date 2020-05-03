import kotlinx.coroutines.*

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    println("Started")
    runBlocking {
        launch {
            delay(1000)
            println("In launch")
        }
        GlobalScope.launch {
            delay(500)
            println("In GlobalScope")
        }
        coroutineScope {
            delay(1500)
            println("In coroutine scope")
        }
    }
    println("Ended")
}