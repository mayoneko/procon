fun main(args: Array<String>) {
    val (a, b, k) = readLine()!!.split(" ").map(String::toInt)
    val c = if (a < b) a else b
    println((c downTo 1).filter { a % it == 0 && b % it == 0 }[k - 1])
}