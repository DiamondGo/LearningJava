import org.junit.Assert
import org.junit.Test
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class StreamTest {

    @Test
    fun testWriteToOutputStream() {
        val fos = FileOutputStream("test_out")
        fos.write("hello".toByteArray())
        fos.close()
        try {
            fos.write("world".toByteArray())
            Assert.fail()
        } catch (e : IOException) {
            //
        }

        File("test_out").delete()
    }
}