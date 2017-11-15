package coroutine

import kotlinx.coroutines.experimental.cancelChildren
import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.selects.select


fun main(args: Array<String>) = runBlocking<Unit> {
    val fizz = fizz(coroutineContext)

    val default = Channel<String>(1)
    default.send("fizz not ready")

    select<Unit> {
        fizz.onReceive {
            value -> println("fizz -> '$value'")
        }
        default.onReceive {
            value -> println("default -> '$value'")
        }
    }

    delay(600)
    default.send("fizz not ready")

    select<Unit> {
        fizz.onReceive {
            value -> println("fizz -> '$value'")
        }
        default.onReceive {
            value -> println("default -> '$value'")
        }
    }

    val buzz = buzz(coroutineContext)

    val timeout = Channel<String>()
    launch {
        delay(300)
        timeout.send("buzz timed out")
    }

    select<Unit> {
        buzz.onReceive {
            value -> println("buzz -> '$value'")
        }
        timeout.onReceive {
            value -> println("timeout -> '$value'")
        }
    }

    coroutineContext.cancelChildren() // cancel fizz & buzz coroutines
}
