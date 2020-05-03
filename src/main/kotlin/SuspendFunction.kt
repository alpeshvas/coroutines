import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Created by @author Alpesh
 *
 */
val n = 1_000_000 // number of threads to launch
var counter = 0
var counterJavaMultiThread = 0;
fun main() {
    runBlocking {
        massiveRun()
    }
    massiveRunMultiThread()
    println("Counter = $counter")
    println("CounterJavaMultiThread = $counterJavaMultiThread ")
}

class MyThread : Thread() {
    override fun run() {
        counterJavaMultiThread ++
    }
}
suspend fun massiveRun() {
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
fun massiveRunMultiThread() {
    val time = measureTimeMillis {
            val threads = mutableListOf<MyThread>()
            repeat(n) {
                val thread = MyThread()
                threads.add(thread)
                thread.start()
            }
            threads.forEach{it.join()}
    }
    println("Completed java multi thread $n actions in $time ms")
}
