import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    runBlocking {
        val job1 = launch {
            delay(3000L)
            println("Job 1 started.")
        }
        job1.invokeOnCompletion {
            println("Job 1 completed")
        }
        delay(500L)
        job1.cancel()
        println("Job 1 cancelled.")
    }
}