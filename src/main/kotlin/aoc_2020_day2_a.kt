import java.io.File

fun main() {
    val values = readFileAsLinesUsingReadLines("input_day2.txt")
    var validPasswords = 0
    values.map {
        val line = it.split(" ")
        val lower = line[0].split("-")[0].toInt()
        val upper = line[0].split("-")[1].toInt()
        val letter = line[1][0]
        val password = line[2]

        val numOfOccurrences = password.filter { it == letter}.count()
        if (numOfOccurrences in lower..upper) {
            validPasswords++
        }
    }
    println(validPasswords)
}

fun readFileAsLinesUsingReadLines(fileName: String): List<String> =
    File(fileName).readLines()