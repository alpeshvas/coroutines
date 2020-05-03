import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("ContextName: $coroutineContext")
            withContext(Dispatchers.IO){
                println("ContextName: $coroutineContext")
            }
            println("ContextName: $coroutineContext")
        }
    }
}