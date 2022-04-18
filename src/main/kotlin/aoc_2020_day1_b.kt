fun main() {
    val values = Utils.getResourceAsText("input_day1.txt")!!.map { it.toInt() }
    for ((i1, _) in values.withIndex()) {
        for((i2, _) in values.withIndex()) {
            for((i3, _) in values.withIndex()) {
                //println("$i1 = ${values[i1]} -- ${i2} = ${values[i2]}")
                val sum = values[i1] + values[i2] + values[i3]
                if (sum == 2020) {
                    println("${values[i1]} and ${values[i2]} and ${values[i3]}")
                    val product = values[i1] * values[i2] * values[i3]
                    println("a is $product")
                    break
                }
            }
        }
    }
}