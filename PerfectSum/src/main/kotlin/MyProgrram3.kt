val list2 = listOf(2,3, 5,6,8,10)
val expectedSum2 = 10

var map = mutableMapOf<Pair<Int, Int>, Boolean>()
var count = 0
fun perfectSum(n : Int, sum: Int) : Boolean {
    if (0 == sum) {
        return true
    }
    if (n == 0) {
        return false
    }

    if (map.containsKey(Pair(n, sum))) {
        ++count
        return map[Pair(n, sum)]!!
    }

    val ps1 = perfectSum(n - 1, sum)
    map[Pair(n-1, sum)] = ps1

    if (list2[n - 1] > sum) {
        return ps1
    }
    val ps2 = perfectSum(n - 1, sum - list2[n - 1])
    map[Pair(n-1, sum-list2[n - 1])] = ps2

    return ps1 || ps2
}

fun main(args:Array<String>) {
    println("Perfect sum possible: ${perfectSum(list2.size, expectedSum2)}")
    println("Count: $count")
    count = 0
    printPerfectSum(list2.size, expectedSum2, mutableListOf())
    println("Count: $count")

}

fun printPerfectSum(idx:Int, sum:Int, l:MutableList<Int>) {
    if (sum == 0) {
        println(l)
        return
    }

    if (idx == 0) {
        return
    }

    if (map.containsKey(Pair(idx,sum))) {
        if (!map[Pair(idx, sum)]!!) {
            ++count
            return
        }
    }

    if (list2[idx - 1] <= sum) {
        l.add(list2[idx - 1])
        printPerfectSum(idx - 1, sum - list2[idx - 1], l)
        l.removeAt(l.size - 1)
    }
    printPerfectSum(idx - 1, sum, l)
}