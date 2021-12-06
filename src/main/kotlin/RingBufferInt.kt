class RingBufferInt constructor(length: Int) {
    var length = length
    var buf = IntArray(length)
    var size = 0
    var index = 0

    fun append(i: Int) {
        buf[index] = i
        index ++
        if (index == length) {
            index = 0
        }
        if(size < length) {
            size ++
        }
    }

    fun sum(): Int {
        var s = 0
        for(i in buf.indices) {
            if (i == size) {
                return s
            }
            s += buf[i]
        }
        return s
    }

    override fun toString(): String {
        return buf.fold("", {r: String, i:Int -> "$r$i,"})
    }
}