import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    GlobalScope.launch {
        println("Before: ${Thread.currentThread().id}")
        delay(1000)
        println("Alpesh")
        println("After: ${Thread.currentThread().id}")
    }
    println("In Hey: ${Thread.currentThread().id}")
    println("Hey, what's up? ")
    Thread.sleep(3000)
}