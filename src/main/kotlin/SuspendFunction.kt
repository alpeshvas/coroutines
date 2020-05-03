import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Created by @author Alpesh
 *
 */
var counter = 0

fun main() {
    runBlocking {
        massiveRun()
    }
    println("Counter = $counter")
}

suspend fun massiveRun() {
    val n = 1_000_000 // number of coroutines to launch
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                    launch {
                         counter++
                    }
            }
        }
    }
    println("Completed $n actions in $time ms")
}
