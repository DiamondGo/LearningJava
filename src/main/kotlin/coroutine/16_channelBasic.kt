package coroutine

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*

fun main(args: Array<String>) = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
        val l = List(5) { channel.send(it * it) }
        println(l)
    }
    // here we print five received integers:
    repeat(5) { println(channel.receive()) }
    println("Done!")
}