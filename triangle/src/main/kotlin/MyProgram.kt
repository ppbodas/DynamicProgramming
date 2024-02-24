var arr = arrayOf(arrayOf(2), arrayOf(4, 1), arrayOf(1, 2, 7))

var cache:MutableMap<Triple<Int, Int, Int>, Int> = mutableMapOf()

fun main(args: Array<String>) {
    arr1.forEach { it.forEach { print(it); print(" ") }; println() }

    print("Max possible sum is ${findMaxSum1(0, 0, 0)}")
}

fun findMaxSum(row: Int, col: Int, sum: Int): Int {
    if (row == arr1.size) {
        return sum
    }

    if (cache.containsKey(Triple(row, col, sum))) {
        return cache[Triple(row, col, sum)]?:0
    }

    val cacheValue = Math.max(findMaxSum1(row + 1, col, sum + arr1[row][col]),
        findMaxSum1(row + 1, col + 1, sum + arr1[row][col]))

    cache[Triple(row, col, sum)] = cacheValue

    return cacheValue
}