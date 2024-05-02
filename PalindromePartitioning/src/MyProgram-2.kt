val inputStr = "racecarpjracecar"

var mem = Array(inputStr.length) {
    Array(inputStr.length) {
        -1
    }
}

fun main(args: Array<String>) {

    val result = isPalindrome2(inputStr, 0, inputStr.length - 1)
    println("Is $inputStr palindrome? $result")

    val count = partitionPalindrome2(inputStr, 0, inputStr.length - 1)
    println("Min count to partition $inputStr is $count")
    // printMem()
}

private fun printMem() {
    for (i in inputStr.indices) {
        for (j in inputStr.indices) {
            print("${mem[i][j]} ")
        }
        println()
    }
}

fun partitionPalindrome2(s: String, startIndex: Int, endIndex: Int): Int {
    if (isPalindrome2(s , startIndex, endIndex) || s.isEmpty()) {
        mem[startIndex][endIndex] = 0
        return 0
    }

    var minCount = Int.MAX_VALUE

    if (mem[startIndex][endIndex] != -1) {
        return mem[startIndex][endIndex]
    }

    for (i in startIndex..< endIndex) {
        val count = partitionPalindrome2(s, startIndex, i) + partitionPalindrome2(s, i + 1, endIndex) + 1
        minCount = minCount.coerceAtMost(count)
    }

    mem[startIndex][endIndex] = minCount

    return minCount
}

fun isPalindrome2(s: String, startIndex: Int, endIndex: Int): Boolean {
    if (startIndex >= endIndex) {
        return true
    }
    return s[startIndex] == s[endIndex] && isPalindrome2(s, startIndex + 1, endIndex - 1)
}