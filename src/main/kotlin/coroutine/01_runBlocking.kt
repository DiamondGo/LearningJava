package coroutine

import kotlinx.coroutines.experimental.*

fun main(args: Array<String>) = runBlocking<Unit> {
    println("Start")

    val job = launch {
        delay(1000)
        println("Hello")
    }

    println("Stop")
    job.join()

    /*
    val c = AtomicInteger()

    for (i in 1..1_000_000)
        thread(start = true) {
            c.addAndGet(i)
        }

    println(c.get())
    */

    /*
    val c = AtomicInteger()

    for (i in 1..1_000_000)
        launch {
            c.addAndGet(i)
        }

    println(c.get())
    */


    /*
    val s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)
    */

    /*
    val jobs = List(100_000) { // launch a lot of coroutines and list their jobs
        launch {
            delay(1000L)
            print(".")
        }
    }
    jobs.forEach { it.join() } // wait for all jobs to complete
    */
}

/*
fun buildString(
        builderAction: (StringBuilder) -> Unit
): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}
*/



