package Aoc2020Dec04

import AdventReader

val path2 = "src/AoCData/AoC2020Dec04b"
val adventReader2 = AdventReader()

var adventInput2 = adventReader2.returnFile2(path2).joinToString("\n") //konverterar listan från List String till String för att kunna splitta den


fun splitNewline1(): List<String> {
    val regex = Regex("\n\n+")
    return adventInput1.split(regex)

}
//funktioner för att validera passen enligt värden

fun isValidByr(str: String) = str.toInt() in 1920..2002


fun isValidIyr(str: String) = str.toInt() in 2010..2020


fun isValidEyr(str: String) = str.toInt() in 2020..2030

fun isValidHcl(str: String): Boolean {
    if(str.startsWith("#") && str.length == 7){
        return str.drop(1).all{it in 'a'..'f'||it in '0'..'9'}
    }
    return false
}

fun isValidEcl(str: String) = str in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    fun isValidHgt(str: String): Boolean {
        return if (str.last().equals('m') && str.substringBeforeLast("cm").toInt() in 150..193)
            true
        else if (str.last().equals('n') && str.substringBeforeLast("in").toInt() in 59..76)
            true
        else false
    }

    fun isValidPid(str: String): Boolean {
        val num = str.toLongOrNull() ?: return false
        return str.length == 9 && num in 0..999999999

    }

fun isValidPass(byr: Boolean,iyr: Boolean, eyr: Boolean, hgt: Boolean, hcl: Boolean, ecl: Boolean, pid: Boolean ): Boolean {
    return byr && iyr && eyr && hgt && ecl && pid
}


fun main() {
    // slår ihop varje pass till en sträng där passen separaras av mellanslag
    val passportStrings = splitNewline1().map { it.replace("\n", " ") }
    // gör en map av strängarna och delar dem mellan kolon
    val stringsToMap = passportStrings.map { passport ->
        passport.split(" ").associate { //associate omvandlar listan nyckel:värde till en Map<String, String>
            val (key, value) = it.split(":") //delar upp key värde genom vad som finns före och efter kolon
            key to value //parar ihop key med värde
        }
    }
/*
isValidPass(stringsToMap.filter{"byr" in it.keys}.forEach {isValidByr(it["byr"].toString())  },
    stringsToMap.filter{"iyr" in it.keys }.forEach { println(isValidIyr(it["iyr"].toString())) },
    stringsToMap.filter{"eyr" in it.keys}.forEach{println(isValidEyr(it["eyr"].toString())) },
    stringsToMap.filter { "hgt" in it.keys }.forEach{ println(isValidHgt(it["hgt"].toString())) },
    stringsToMap.filter{"hcl" in it.keys}.forEach{(isValidHcl(it["hcl"].toString())) },
    stringsToMap.filter { "ecl" in it.keys }.forEach{(isValidEcl(it["ecl"].toString())) },
    stringsToMap.filter {"pid" in it.keys}.forEach {(isValidPid(it["pid"].toString()))})
 */

    fun areAllFieldsValid(stringsToMap: List<Map<String, String>>): List<Map<String, String>> {
        return stringsToMap.filter { passport ->
            val isValidByr = "byr" in passport.keys && isValidByr(passport["byr"].toString())
            val isValidIyr = "iyr" in passport.keys && isValidIyr(passport["iyr"].toString())
            val isValidEyr = "eyr" in passport.keys && isValidEyr(passport["eyr"].toString())
            val isValidHgt = "hgt" in passport.keys && isValidHgt(passport["hgt"].toString())
            val isValidHcl = "hcl" in passport.keys && isValidHcl(passport["hcl"].toString())
            val isValidEcl = "ecl" in passport.keys && isValidEcl(passport["ecl"].toString())
            val isValidPid = "pid" in passport.keys && isValidPid(passport["pid"].toString())

            isValidByr && isValidIyr && isValidEyr && isValidHgt && isValidHcl && isValidEcl && isValidPid
        }
    }

    val validPassList = areAllFieldsValid(stringsToMap)
    println(validPassList.size)




//högre ordningens funktion!!!
    //stringsToMap.filter{"byr" in it.keys}.forEach {println(isValidByr(it["byr"].toString()))  }
    //stringsToMap.filter{"iyr" in it.keys }.forEach { println(isValidIyr(it["iyr"].toString())) }
   // stringsToMap.filter{"eyr" in it.keys}.forEach{println(isValidEyr(it["eyr"].toString())) }
//stringsToMap.filter { "hgt" in it.keys }.forEach{ println(isValidHgt(it["hgt"].toString())) }
//stringsToMap.filter{"hcl" in it.keys}.forEach{println(isValidHcl(it["hcl"].toString())) }
    // stringsToMap.filter { "ecl" in it.keys }.forEach{ println(isValidEcl(it["ecl"].toString())) }
   // stringsToMap.filter {"pid" in it.keys}.forEach {println(isValidPid(it["pid"].toString()))}



}
