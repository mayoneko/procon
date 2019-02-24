//dame

fun main(args: Array<String>) {
    val (n, a, b, c) = readLine()!!.split(" ").map(String::toInt)
    val ls = mutableListOf<Int>()
    for (i in 1..n) {
        ls.add(readLine()!!.toInt())
    }
    println(dfa(n, ls, a, b, c, 0, 0, 0, 0))
}

fun dfa(n: Int, l: List<Int>, A: Int, B: Int, C: Int, cur: Int, a: Int, b: Int, c: Int): Int {
    if (cur == n) {
        return if (listOf(a, b, c).min()!! > 0) {
            Math.abs(a - A) + Math.abs(b - B) + Math.abs(c - C) - 30
        } else {
            10000000
        }
    }
    val ret0 = dfa(n, l, A, B, C, cur + 1, a, b, c)
    val ret1 = dfa(n, l, A, B, C, cur + 1, a + l[cur], b, c) + 10
    val ret2 = dfa(n, l, A, B, C, cur + 1, a, b + l[cur], c) + 10
    val ret3 = dfa(n, l, A, B, C, cur + 1, a, b, c + l[cur]) + 10
    return listOf(ret0, ret1, ret2, ret3).min()!!
}

