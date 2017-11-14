package coroutine

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*

fun produceSquares() = produce<Int> {
    for (x in 1..5) send(x * x)
}

fun main(args: Array<String>) = runBlocking<Unit> {
    val squares = produceSquares()
    squares.consumeEach { println(it) }
    println("Done!")
}