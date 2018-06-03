package coroutine


import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*

fun main(args: Array<String>) = runBlocking<Unit> {
    val channel = Channel<Int>()
    launch {
        (1..5).forEach { x -> channel.send(x * x) }
        channel.close() // we're done sending
    }
    // here we print received values using `for` loop (until the channel is closed)
    for (y in channel) println(y)
    println("Done!")

    try {
            channel.send(99)
    } catch (e : ClosedSendChannelException) {
        println("got")
    }

    try {
        channel.receive()
    } catch (e : ClosedReceiveChannelException) {
        println("got 2")
    }
}