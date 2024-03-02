
val arr = arrayOf(50, 3, 10, 7, 40, 80)

var dp = MutableList(arr.size){-1}

/*
lis at idx => 1 + Max (lis(j)) where j < idx and arr[j] <= arr[idx]
Or 1
 */
fun lis(idx: Int) : Int {
    if (idx == 0) {
        return 1
    }

    if (-1 != dp[idx]) {
        return dp[idx]!!
    }

    var maxEarlierLIS = 0
    for (j in idx -1 downTo 0) {
        if (arr[j] < arr[idx]) {
            maxEarlierLIS = lis(j).coerceAtLeast(maxEarlierLIS)
        }
    }

    dp[idx] = 1 + maxEarlierLIS

    return 1 + maxEarlierLIS
}

fun main(args:Array<String>) {
    println("Hello World")
    arr.forEach { print("$it ") }
    println()
    dp[0] = 1
    println(lis(arr.size - 1))
    printLIS()
}

fun printLIS() {
    assert(dp.filter { -1 == it }.isEmpty())
    println(dp)

    var lisValue = dp.max()
    var idx = dp.indexOf(lisValue)

    var output = mutableListOf<Int>()
    output.add(arr[idx])

    lisValue--

    for (j in (idx - 1) downTo 0) {
        if ((lisValue == dp[j]) && (output.last() > arr[j])) {
            output.add(arr[j])
            lisValue--
        }
    }

    println(output.asReversed())
}