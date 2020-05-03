import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    runBlocking {
        launch(CoroutineName("Heyyyyy")) {
            println("coroutine context is  this: ${coroutineContext}")
        }
    }
}