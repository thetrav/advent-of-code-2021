import java.io.BufferedReader

class day1 {
    fun run() {
        val input = this::class.java.classLoader.getResource("input_1.txt").openStream().bufferedReader()
        print("count: ${window(input)}\n")
    }

    fun countIncreases(input: BufferedReader): Int {
        var prev = -1
        var count = 0
        input.forEachLine {
            val next = Integer.parseInt(it)
            if (prev >=0 && next > prev) {
                count++
            }
            prev = next
        }
        return count
    }

    fun window(input: BufferedReader): Int {
        var lastNum = -1
        var ticks = 0
        val prev = RingBufferInt(3)
        val next = RingBufferInt(3)
        var count = 0

        input.forEachLine{
            val num = Integer.parseInt(it)
            next.append(num)
            if(ticks++ < 3) {
                prev.append(num)
                return@forEachLine
            } else {
                if(lastNum >0) {
                    prev.append(lastNum)
                }
                if (prev.sum() < next.sum()) {
                    count++
                }
            }
            lastNum = num
        }
        return count
    }
}