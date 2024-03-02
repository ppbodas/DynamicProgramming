val first = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA"
val second = "GTCGTTCGGAATGCCGTTGCTCTGTAAA"

val map = mutableMapOf<Pair<Int, Int>, Int>()

var count = 0
var recursionCount = 0

fun lcs(m:Int, n:Int) : Int {
    if ((m <= 0) || (n <= 0)) {
        return 0
    }
    ++recursionCount

    if (map.containsKey(Pair(m, n))) {
        count++
        return map[Pair(m, n)]!!
    }

    if (first[m-1] == second[n-1]) {
        val l1 = lcs(m - 1, n - 1)
        map[Pair(m-1, n-1)] = l1
        return 1 + l1
    }

    val l2 = lcs(m - 1, n)
    val l3 = lcs(m, n - 1)
    map[Pair(m-1, n)] = l2
    map[Pair(m, n-1)] = l3

    return l2.coerceAtLeast(l3)
}

fun main(args:Array<String>) {
    println("LCS ${lcs(first.length, second.length)}")
    println("Number of times map was used $count")
    println("Number of times recursion was used $recursionCount")

    println("LCS string ${printLCS()}")
}

// Print LCS string
fun printLCS() : String {
    val sb = StringBuilder()
    var m = first.length
    var n = second.length

    while (m > 0 && n > 0) {
        if (first[m-1] == second[n-1]) {
            sb.append(first[m-1])
            m--
            n--
        } else if (map[Pair(m-1, n)]!! > map[Pair(m, n-1)]!!) {
            m--
        } else {
            n--
        }
    }

    return sb.reverse().toString()
}


