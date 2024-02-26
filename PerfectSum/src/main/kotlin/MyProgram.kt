val list = listOf(2,3, 5,6,8,10)
val expectedSum = 10


fun findSum(id:Int, sum: Int,  currentList:List<Int>)  {
    if (sum == expectedSum) {
        currentList.forEach { print(it); print(" ") }
        println()
        return
    }
    if (id == list.size) {
        return
    }

    var l1 = mutableListOf<Int>()
    l1.addAll(currentList)
    l1.add(list[id])

    findSum(id + 1, sum + list.get(id), l1)
    findSum(id + 1, sum, currentList)
}

fun main(args: Array<String>) {
    list.forEach { print(it); print(" ")}
    println()

    findSum(0, 0, listOf())
}