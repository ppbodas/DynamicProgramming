fun main(args: Array<String>) {
    val inputStr = "geek"
    val result = isPalindrome(inputStr, 0, inputStr.length - 1)
    println("Is $inputStr palindrome? $result")

    val count = partitionPalindrome(inputStr, 0, inputStr.length - 1)
    println("Min count to partition $inputStr is $count")
}

fun partitionPalindrome(s: String, startIndex: Int, endIndex: Int): Int {
    if (isPalindrome(s , startIndex, endIndex) || s.isEmpty()) {
        return 0
    }

    var minCount = Int.MAX_VALUE

    for (i in startIndex..< endIndex) {
        val count = partitionPalindrome(s, startIndex, i) + partitionPalindrome(s, i + 1, endIndex) + 1
        minCount = minCount.coerceAtMost(count)
    }

    return minCount
}

fun isPalindrome(s: String, startIndex: Int, endIndex: Int): Boolean {
    if (startIndex >= endIndex) {
        return true
    }
    return s[startIndex] == s[endIndex] && isPalindrome(s, startIndex + 1, endIndex - 1)
}