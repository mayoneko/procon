//dame

fun main(args: Array<String>) {
    val (n, a, b, c) = readLine()!!.split(" ").map(String::toInt)
    val ls = mutableListOf<Int>()
    val ss = listOf(a, b, c)
    for (i in 1..n) {
        ls.add(readLine()!!.toInt())
    }


}


//{
//    var lsl = ls2lsl(ls)
//    for (i in 0 until n - 3) {
//        lsl = lsl.plus(lsMix(lsl))
//    }
//    ss.forEach {
//        println(nearestSearch(it, lsl))
//    }
//}

fun ls2lsl(ls: List<Int>): List<Pair<Int, List<Int>>> {
    return ls.mapIndexed { id, it ->
        it to listOf(id)
    }
}

fun nearestSearch(a: Int, lsl: List<Pair<Int, List<Int>>>): List<Pair<Int, List<Int>>> {
    return lsl.sortedBy {
        Math.abs(it.first - a)
    }
}

fun lsMix(lsl: List<Pair<Int, List<Int>>>): List<Pair<Int, List<Int>>> {
    val lil = mutableListOf<Pair<Int, List<Int>>>()
    for (i in 0 until lsl.size) {
        for (j in 1 until lsl.size) {
            if (lsl[i].second.any { lsli -> lsl[j].second.any { it <= lsli } }) continue
            lil.add(lsl[i].first + lsl[j].first to lsl[i].second.plus(lsl[j].second))
        }
    }
    return lil
}


fun addSearch(a: Int, ls: List<Int>): List<Int> {
    return ls.filter {
        it in a - 9..a + 9
    }
}

fun joinSearch(a: Int, ls: List<Int>): List<Pair<Int, Int>> {
    val li = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until ls.size) {
        for (j in 1 until ls.size) {
            if (i >= j) continue
            if (ls[i] + ls[j] == a) li.add(ls[i] to ls[j])
        }
    }
    return li
}

