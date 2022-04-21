fun main() {
  val groups = readInGroups("input_day6.txt")
  val combinedGroups = groups.map { it.joinToString("") { it.trim() } }
  val distinctAnswers:MutableList<Set<String>> = mutableListOf()
  var total = 0
  for (group in combinedGroups) {
    val setOfAnswers: MutableSet<String> = mutableSetOf()
    for (l in group) {
      setOfAnswers.add(l.toString())
    }
    distinctAnswers.add(setOfAnswers)
  }

  for (a in distinctAnswers) {
    total = total + a.size
  }
  println(total)
  println(distinctAnswers.sumOf { it.size })
}

fun readInGroups(fileName: String): List<List<String>> {
  val rawRows =  Utils.getResourceAsText(fileName)
  val groups: MutableList<MutableList<String>> = mutableListOf()
  var groupAnswers = mutableListOf<String>()
  for ((i,rawRow) in rawRows!!.withIndex()) {
    if(rawRow.isNotBlank()) {
      groupAnswers.add(rawRow.trim())
    }
    else if (rawRow.isBlank() || i == rawRows.size+1){
      groups.add(groupAnswers)
      groupAnswers = mutableListOf()
    }
  }
  return groups
}