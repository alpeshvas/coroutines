import kotlinx.coroutines.runBlocking

suspend fun printHello(num: Int){
    println("Hello")
}
fun main(){
    runBlocking {
        repeat(n){
            printHello(it)
        }
        println("final")
    }
}