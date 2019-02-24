fun main(args:Array<String>) {
    val n= readLine()!!.toInt()
    var result = 0.0
    for(i in 1..n){
        val (x,u)=readLine()!!.split(" ")
        if(u=="JPY") {
            result += x.toDouble()
        }else{
            result += ( x.toDouble() * 380000.0 )
        }
    }
    println(result)
}