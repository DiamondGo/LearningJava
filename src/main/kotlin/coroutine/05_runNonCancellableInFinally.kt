package coroutine

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking<Unit> {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("I'm running finally")
            run(NonCancellable) {
                println("Some job can not be canceled")
                delay(1000L)
                println("And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // delay a bit
    println("coroutine.main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("coroutine.main: Now I can quit.")
}