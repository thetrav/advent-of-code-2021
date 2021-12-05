class Main {
    fun countIncreases(fileName: String): Int {
        var prev = -1
        var count = 0
        val input = this::class.java.classLoader.getResource(fileName)
        input.openStream().bufferedReader().forEachLine {
            val next = Integer.parseInt(it)
            if (prev >=0 && next > prev) {
                count++
            }
            prev = next
        }
        return count
    }
}

fun main(args: Array<String>) {
    val m = Main()
    print("count: ${m.countIncreases(args[0])}")
}