package coroutine

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking<Unit> {
    val job = launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // just quit after delay

    println("coroutine.main: I'm tired of waiting!")
    //job.cancel() // cancels the job
    //job.join() // waits for job's completion
    job.cancelAndJoin()
    println(job.isActive)
    println(job.isCancelled)
    println(job.isCompleted)
    println("coroutine.main: Now I can quit.")
}