fun main() {
    val lines = readFileAsLinesUsingReadLines("input_day3.txt")

    val slopes: List<Pair<Int, Int>> = listOf(Pair(1,1), Pair(3,1), Pair(5,1), Pair(7,1), Pair(1,2))
    val tree = '#'
    val answers:MutableList<Int> = mutableListOf(1)

    for(slope in slopes) {
        var treeCount = 0
        var position = Pair(0,0)
        for ((i1, _) in lines.withIndex()) {
            position = move(position, slope, lines[slope.second])
            if (atBottom(position.second, lines.size)) {
                break
            }
            else if (lines[position.second][position.first] == tree) {
                treeCount++
            }
        }
        println("$slope $treeCount")
        answers.add(treeCount)
    }
    println("${answers.reduce(Int::times)}")
}

fun atBottom(index: Int, numberOfLines: Int) = index >= numberOfLines

fun move(coords:Pair<Int, Int>, movement: Pair<Int, Int>, path: String): Pair<Int, Int> {
    val limit = path.length
    var newFirst = coords.first + movement.first
    if (newFirst >= limit) {
        newFirst -= limit
    }
    return Pair(first = newFirst, second = coords.second + movement.second)

}

// 193