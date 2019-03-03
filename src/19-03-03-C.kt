fun main(args: Array<String>) {
    val s = readLine()!!
    val p0 = s.count { it == '0' }
    val p1 = s.count { it == '1' }
    if (p0 > p1) {
        println(p1 * 2)
    } else {
        println(p0 * 2)
    }
}