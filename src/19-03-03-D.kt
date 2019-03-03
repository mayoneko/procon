//TLE

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val pl = mutableListOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (a, b) = readLine()!!.split(" ").map(String::toInt)
        pl.add(a to b)
    }
//    println(pl)
    val max = (n * (n - 1) / 2).toLong()
    val rl = mutableListOf(max)
    var il = (1..n).map { mutableListOf(it) }.toMutableList()
    for (i in 0 until pl.size - 1) {
        val pln = pl[pl.size - 1 - i]
        val ilt = il
        for (j in 0 until il.size) {
            if (il[j].contains(pln.first)) {
                if (!il[j].contains(pln.second)) {
                    il.filter { it.contains(pln.second) }.forEach {
                        ilt[j].plusAssign(it)
                        ilt.remove(it)
                    }
                }
                break
            } else if (il[j].contains(pln.second)) {
                il.filter { it.contains(pln.first) }.forEach {
                    ilt[j].plusAssign(it)
                    ilt.remove(it)
                }
                break
            }
        }

        var rr: Long = 0
        for (j in 0 until ilt.size - 1) {
            for (k in j + 1 until ilt.size) {
//                println(j to k)
                rr += ilt[j].size * ilt[k].size
            }
        }
        rl.add(rr)
        il = ilt
//        println(il)
    }
    println(rl.reversed().joinToString("\n"))
}