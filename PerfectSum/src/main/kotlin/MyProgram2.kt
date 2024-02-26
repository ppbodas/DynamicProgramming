val list1 = listOf(3, 34, 4, 12, 5, 2)
val expectedSum1 = 9

var dp = Array(list1.size + 1) { Array(expectedSum1 + 1) { false } }

/*
Bottoms up implementation
 */

fun printDPArray() {
    for (i in 0..expectedSum1) {print ("$i \t")}
    println()
    println("-".repeat(100))
    dp.forEach { it.forEach { print("$it \t")}; println()}
}

/*
* dp(i,j) = dp(i-1,j) || (dp(i-1, j-l(i)) if j >= l(i)
* dp(i,j) = dp(i-1, j) if j < l(i)
* */
fun main(args:Array<String>) {
    // Base condition
    for (i in 0..list1.size) {
        dp[i][0] = true
    }

    println(fillDPArray())
    println("-".repeat(100))

    printDPArray()
}

private fun fillDPArray(): Boolean {
    for (i in 1.. list1.size) {
        for (j in 1..expectedSum1) {
            if (j < list1.get(i-1)) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - list1.get(i-1)]
            }
        }
    }

    // printDPArray()

    return dp[list1.size][expectedSum1]
}