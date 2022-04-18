import java.io.File

fun main() {
    val values = readFileAsLinesUsingReadLines("input_day2.txt")
    var validPasswords = 0
    values.map {
        val line = it.split(" ")
        val first = line[0].split("-")[0].toInt()
        val second = line[0].split("-")[1].toInt()
        val letter = line[1][0]
        val password = line[2]

        if((password[first-1] == letter && password[second-1] != letter) ||
            (password[first-1] != letter && password[second-1] == letter)) {
            validPasswords++
        }
    }
    println(validPasswords)
}