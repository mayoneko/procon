fun main(args:Array<String>) {
    val s= readLine()!!
    val (y,m,d)=s.split("/").map(String::toInt)
    if(m<=4){
        println("Heisei")
    }else{
        println("TBD")
    }
}