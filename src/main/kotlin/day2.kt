import java.io.BufferedReader

const val forward = "forward "
const val up = "up "
const val down = "down "

class day2 {
    fun run () {
        val input = this::class.java.classLoader.getResource("input_2.txt").openStream().bufferedReader()
        print("position: ${positionWithAim(input)}\n")
    }

    fun testAndApply(line: String, prefix: String, fn: (Int) -> Unit): Boolean {
        if(line.startsWith(prefix)) {
            fn(Integer.parseInt(line.substringAfter(prefix)))
            return true
        }
        return false
    }

    fun position(input: BufferedReader): Int {
        var depth = 0
        var horizontal = 0
        input.forEachLine {
            testAndApply(it, forward, {horizontal += it}) ||
            testAndApply(it, up, {depth -= it}) ||
            testAndApply(it, down, {depth += it})
        }
        return depth * horizontal
    }

    fun positionWithAim(input: BufferedReader): Int {
        var depth = 0
        var aim = 0
        var horizontal = 0
        input.forEachLine {
            testAndApply(it, forward, {
                horizontal += it
                depth += aim * it
            }) ||
                    testAndApply(it, up, {aim -= it}) ||
                    testAndApply(it, down, {aim += it})
        }
        return depth * horizontal
    }
}