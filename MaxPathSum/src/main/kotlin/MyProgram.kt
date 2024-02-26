var arr = arrayOf(arrayOf(4,2, 3, 4),
    arrayOf(2, 9, 1, 10),
    arrayOf(15, 1, 3, 0),
    arrayOf(16, 92, 41, 44))

var map = mutableMapOf<Pair<Int, Int>, Int>()

var count = 0

val m = arr.size
val n = arr[0].size

fun printArray() {
    arr.forEach {
        it.forEach { print("$it "); }
        println() }
}

fun main() {
    printArray()
    println(findMax())
}

fun findMax(): Int {
    var max = Int.MIN_VALUE
    for (col in 0..<n) {
        max = max.coerceAtLeast(findMaxFrom(0, col))
    }
    println("Number of times map was used $count")
    return max
}

fun findMaxFrom(row: Int, col: Int) : Int {
    if (row >= m) {
        return 0
    }
    if ((col >= n) || (col < 0)) {
        return 0
    }

    if (map.containsKey(Pair(row, col))) {
        count += 1
        return map[Pair(row, col)]!!
    }

    val dpElementValue = arr[row][col] + findMaxFrom(row + 1, col).coerceAtLeast(findMaxFrom(row + 1, col - 1))
        .coerceAtLeast(findMaxFrom(row + 1, col + 1))

    map[Pair(row, col)] = dpElementValue
    return dpElementValue
}
