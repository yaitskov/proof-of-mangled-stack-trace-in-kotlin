package op

import kotlinx.coroutines.runBlocking
import org.junit.Test

class StackTraceTest {
    @Test
    fun koroChase() = runBlocking {  // line 8
        a(0)
        a(1)
        a(2)
        a(3)
        a(10)
        a(11)  // line 14. I want to see it in stack trace
        a(12)
    }

    suspend fun a(x: Int): Unit = b(x)  // line 18
    suspend fun b(x: Int): Unit = c(x)
    suspend fun c(x: Int) {
        if (x > 10) {
            throw NullPointerException("ops x = ${x} > 0")
        }
    }
}
