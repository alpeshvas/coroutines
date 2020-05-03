import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    runBlocking {
        repeat(10_000_000){
            launch {
                println(".")
            }
        }
    }
}