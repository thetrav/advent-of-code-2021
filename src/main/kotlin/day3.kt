import java.io.BufferedReader

const val length = 12

class day3 {


    fun run() {
        val input = this::class.java.classLoader.getResource("input_3.txt").openStream().bufferedReader()
//        println("bits: ${bits(input)}\n")
        println("lifeSupport: ${lifeSupportRating(input)}")
    }

    fun toInt(binary: IntArray): Int {
        val bStr = binary.fold("", {r, s -> r+"$s"})
        return Integer.valueOf(bStr, 2)
    }

    fun bits(input: BufferedReader): Int {
        val sums = IntArray(length)
        input.forEachLine {
            for(i in sums.indices) {
                when {
                    it[i] == '0' -> sums[i] -=1
                    it[i] == '1' -> sums[i] +=1
                }
            }
        }

        val gamma = IntArray(length)
        val epsilon = IntArray(length)
        for(i in sums.indices) {
            if (sums[i] >= 0) {
                gamma[i] = 1
                epsilon[i] = 0
            }
            else {
                gamma[i] = 0
                epsilon[i] = 1
            }
        }
        return 0
    }

    fun selectMostCommon(pair: Pair<List<String>, List<String>>):List<String> {
        if (pair.first.size >= pair.second.size) {
            return pair.first
        }
        return pair.second
    }

    fun selectLeastCommon(pair: Pair<List<String>, List<String>>):List<String> {
        if (pair.first.size < pair.second.size) {
            return pair.first
        }
        return pair.second
    }

    fun search(source: List<String>,
               index: Int,
               selectBranch: (Pair<List<String>,List<String>>) -> List<String>): String {
        if(source.size == 1) {
            return source.first()
        }

        val parts = source.partition{it[index] == '1'}
        val branch = selectBranch(parts)
        return search(branch, index+1, selectBranch)
    }

    fun lifeSupportRating(input: BufferedReader): Int {
        val allLines = input.readLines()
        val parts = allLines.partition{it[0] == '1'}
        val oxygenGeneratorRating = search(selectMostCommon(parts), 1) { selectMostCommon(it) }
        val co2ScrubberRating = search(selectLeastCommon(parts), 1) { selectLeastCommon(it) }
        return Integer.valueOf(oxygenGeneratorRating, 2) * Integer.valueOf(co2ScrubberRating, 2)
    }
}