import java.io.File

fun main() {
    val values = readFileAsLinesUsingReadLinesToInts("input_day1.txt")

    for ((i1, v1) in values.withIndex()) {
        for((i2, v2) in values.withIndex()) {
            //println("$i1 = ${values[i1]} -- ${i2} = ${values[i2]}")
            val sum = values[i1] + values[i2]
            if (sum == 2020) {
                println("${values[i1]} and ${values[i2]}")
                val product = values[i1] * values[i2]
                println("a is $product")
                break
            }
        }
    }
}

fun readFileAsLinesUsingReadLinesToInts(fileName: String): List<Int> =
    File(fileName).readLines().map {it.toInt() }