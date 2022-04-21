fun main() {
  val groups = readInGroups("input_day6.txt")

  val groupCounts:MutableList<Int> = mutableListOf()
  for (group in groups) {
    val initialSetOfAnswers = group[0].toMutableList()
    val finalSetOfAnswers = group[0].toMutableList()
    for (l in initialSetOfAnswers) {
      for (answers in group) {
        if(!answers.contains(l)) {
          finalSetOfAnswers.remove(l)
        }
      }
    }
    groupCounts.add(finalSetOfAnswers.size)
  }
  println("${groupCounts.sumOf { it }}")
}

