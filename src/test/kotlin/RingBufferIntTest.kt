import kotlin.test.Test
import kotlin.test.assertEquals

class RingBufferIntTest {
    @Test
    fun testData() {
        val b = RingBufferInt(3)
        assertEquals(b.sum(), 0)
        assertEquals(b.size, 0)
        b.append(1)
        assertEquals(b.sum(), 1)
        assertEquals(b.size, 1)
        b.append(2)
        assertEquals(b.sum(), 3)
        assertEquals(b.size, 2)
        b.append(3)
        assertEquals(b.sum(), 6)
        assertEquals(b.size, 3)
        b.append(4)
        assertEquals(b.sum(), 9)
        assertEquals(b.size, 3)
    }
}