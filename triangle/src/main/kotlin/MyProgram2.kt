var arr1 = arrayOf(arrayOf(100), arrayOf(4, 100), arrayOf(1, 2, 100), arrayOf(1, 2, 100, 10), arrayOf(1, 2, 1, 100, 1))

var cache1:MutableMap<DPElement, Int> = mutableMapOf()

data class DPElement(val row: Int, val col: Int, val sum: Int)

fun main(args: Array<String>) {
    arr1.forEach { it.forEach { print(it); print(" ") }; println() }
    println("*".repeat(20))
    println()
//    val dpElement1 = DPElement(2, 3, 5)
//    val dpElement2 = DPElement(2, 3, 7)
//
//    println("DpElement1 and DpElement2 ${dpElement1 == dpElement2}")

    print("Max possible sum is: ${findMaxSum1(0, 0, 0)}")
}

fun findMaxSum1(row: Int, col: Int, sum: Int): Int {
    if (row == arr1.size) {
        return sum
    }

    if (cache1.containsKey(DPElement(row, col, sum))) {
        return cache1[DPElement(row, col, sum)]?:0
    }

    val cacheValue = Math.max(findMaxSum1(row + 1, col, sum + arr1[row][col]),
        findMaxSum1(row + 1, col + 1, sum + arr1[row][col]))

    cache1[DPElement(row, col, sum)] = cacheValue

    return cacheValue
}