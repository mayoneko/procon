fun main(args: Array<String>) {
    val s = readLine()!!
    val (a, b, c) = s.split(" ").map(String::toInt)
    val p = if (b / a < c) b / a else c
    println(p)
}