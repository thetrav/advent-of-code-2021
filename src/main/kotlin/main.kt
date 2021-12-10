

fun main(args: Array<String>) {
    when {
        "1" in args -> day1().run()
        "2" in args -> day2().run()
        "3" in args -> day3().run()
        "pings" in args -> pings().run()
    }
}