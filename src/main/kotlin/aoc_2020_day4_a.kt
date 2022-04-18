import java.io.File

val validEyeColors = listOf<String>("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

fun main() {
    val passports = readInPassportBatch("input_day4.txt")
    val countOfValidPassports = passports.count { isPassportValid(it) }
    println("$countOfValidPassports")
}

fun isPassportValid(passport: MutableMap<String, String>):Boolean {
    val validFields:List<String> = listOf("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")
    var validPassport = true
    if (!passport.keys.containsAll(validFields)) {
        validPassport = false
    }
    else {
        for(field in passport.keys) {
            if(!validField(field, passport.getValue(field))) {
                validPassport = false
                break
            }
        }
    }
    return validPassport
}

fun readInPassportBatch(fileName: String): MutableList<MutableMap<String, String>> {
    val rows = Utils.getResourceAsText(fileName)
    val passports: MutableList<MutableMap<String, String>> = mutableListOf()
    var pMap: MutableMap<String, String> = mutableMapOf()
    for (row in rows!!) {
        if (!row.isEmpty()) {
          val values = row.split(" ")
          for (value in values) {
              val field = value.split(":")
              pMap.put(field[0], field[1])
          }
        }
        else {
            passports.add(pMap)
            pMap = mutableMapOf()
        }
    }
    return passports
}

fun validField(field: String, value: String): Boolean =
    when (field) {
        "cid" -> true
        "byr" -> value.toInt() in 1920..2022
        "iyr" -> value.toInt() in 2010..2020
        "eyr" -> value.toInt() in 2020..2030
        "hgt" -> {
            if (value.contains('c')) {
                val num = value.split('c')[0]
                num.toInt() in 150..193
            }
            else {
                val num = value.split('i')[0]
                num.toInt() in 59..76
            }
        }
        "hcl" -> {
            val hclPattern = Regex("^#([a-f\\d]{6})")
            hclPattern.matches(value)
        }
        "ecl" -> validEyeColors.contains(value)
        "pid" -> {
            val pidPattern = Regex("[\\d]{9}")
            pidPattern.matches(value)
        }
        else -> false
    }
