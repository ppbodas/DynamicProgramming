fun main(args:Array<String>) {
    val inputArray = arrayOf(300, 10, 20, 100, 20)

    println("Input Array: " + inputArray.contentToString())

    var output = findLongestIncreasingSubsequence(inputArray)
    println("LIS Array: " + output.contentToString())

    printLongestSequence(inputArray, output)
}

fun printLongestSequence(inputArray: Array<Int>, output: Array<Int>) {
    // Find max index from output array
    val lastIndex = output.indexOf(output.maxOrNull())
    val maxIndex = lastIndex
    var lis = output[lastIndex]
    val sequence = mutableListOf<Int>()
    sequence.add(inputArray[lastIndex])
    lis -= 1

    for (i in maxIndex - 1 downTo 0) {
        if ((output[i] == lis) && (inputArray[i] < inputArray[lastIndex])){
            sequence.add(inputArray[i])
            lis -= 1
        }
    }
    sequence.reversed().map { print("$it ") }
}

fun findLongestIncreasingSubsequence(inputArray: Array<Int>) : Array<Int> {
    val longestSequence = Array(inputArray.size) { 1 }

    for (i in inputArray.indices) {
        for (j in 0 until i) {
            if (inputArray[i] > inputArray[j]) {
                longestSequence[i] = Math.max(longestSequence[i], longestSequence[j] + 1)
            }
        }
    }
    return longestSequence
}
