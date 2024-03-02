val arr1 = arrayOf(10, 22, 9, 33, 21, 50, 41, 60)

val arrSize = arr1.size

var dp2 = Array(arr1.size) {0}
fun main(args:Array<String>) {
    println("Hello World")

    lis()
    println("Max LIS is ${dp2.max()}")
    println(dp2.asList())
}

fun lis() : Unit {
    dp2[0] = 1

    for (i in 1..< arrSize) {
        dp2[i] = 1
        for (j in 0..< i) {
            if (arr1[i] > arr1[j]) {
                dp2[i] = dp2[i].coerceAtLeast(dp2[j] + 1)
            }
        }
    }
}