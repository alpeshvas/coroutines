import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    runBlocking {
        val timeInMillisecond = measureTimeMillis {
            val firstDefferedValue = async { getFirstValue() }
            val secondDifferedValue = async { getSecondValue() }
            val total = firstDefferedValue.await() + secondDifferedValue.await()
            println("Total is $total")
        }
        println("Time in millisecond: ${timeInMillisecond}")
    }
}

suspend fun getFirstValue():Int {
    val value = Random.nextInt()
    delay(3000)
    return value
}
suspend fun getSecondValue(): Int{
    val value = Random.nextInt()
    delay(4000)
    return value
}