import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.RuntimeException

/**
 * Created by @author Alpesh
 *
 */
fun main() {
    runBlocking {
        val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable ->
            println("Exception caught ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(exceptionHandler) {
           throw RuntimeException("Exception thrown")
        }

        job.join()
        val deferred = GlobalScope.async {
            throw ArithmeticException("Artithmetic exception thrown")
        }

        runCatching { deferred.await()}.onFailure { println("Exception thrown in await: ${it.message}") }
    }
}