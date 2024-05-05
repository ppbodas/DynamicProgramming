val inputArray = intArrayOf(40, 20, 30, 10, 30)
// 40 * 20, 20 * 30, 30 * 10, 10 * 30

val mem = Array(inputArray.size) { IntArray(inputArray.size) {-1} }

fun main(args:Array<String>) {

    println("Input Array: ${inputArray.contentToString()}")

    println(multiplicationCount(inputArray, 0, inputArray.size - 1))

    mem.map { it.map { print("$it ") }; println() }
}
fun multiplicationCount(inputArray: IntArray, start: Int, end: Int) : Int {
    if  (end - start <= 1) {
        mem[start][end] = 0
    }

    if (end - start == 2) {
        mem[start][end] = inputArray[start] * inputArray[start+1] * inputArray[end]
    }

    if (mem[start][end] != -1) {
        return mem[start][end]
    }

    var minimumCount = Integer.MAX_VALUE

    for (i in start + 1..< end) {
        val left = multiplicationCount(inputArray, start, i)
        val right = multiplicationCount(inputArray, i, end)
        minimumCount = Math.min(minimumCount, left + right + inputArray[start] * inputArray[i] * inputArray[end])
    }

    mem[start][end] = minimumCount

    return minimumCount
}