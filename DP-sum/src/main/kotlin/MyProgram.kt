val m = 6
val arr = arrayOf(3, 1, 7, 8)
val cache:MutableMap<Pair<Int, Int>, Boolean> = mutableMapOf()

fun main(args: Array<String>) {
    println(isSubSet(0, 0))
}

fun isSubSet(id : Int, sum: Int) : Boolean {
    if (id == arr.size) {
        if (0 == sum) {
            return false
        }
        return (0 == sum % m)
    }

    if (cache.containsKey(Pair(id, sum))) {
        return cache[Pair(id,sum)]?:false
    }

    val cacheValue = isSubSet(id + 1, sum) || isSubSet(id + 1, sum + arr[id])
    cache[Pair(id, sum)] = cacheValue
    return cacheValue
}
