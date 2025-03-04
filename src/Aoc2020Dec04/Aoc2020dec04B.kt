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



//högre ordningens funktion!!!
    //stringsToMap.filter{"byr" in it.keys}.forEach {println(isValidByr(it["byr"].toString()))  }
    //stringsToMap.filter{"iyr" in it.keys }.forEach { println(isValidIyr(it["iyr"].toString())) }
   // stringsToMap.filter{"eyr" in it.keys}.forEach{println(isValidEyr(it["eyr"].toString())) }
//stringsToMap.filter { "hgt" in it.keys }.forEach{ println(isValidHgt(it["hgt"].toString())) }
stringsToMap.filter{"hcl" in it.keys}.forEach{println(isValidHcl(it["hcl"].toString())) }
    // stringsToMap.filter { "ecl" in it.keys }.forEach{ println(isValidEcl(it["ecl"].toString())) }
   // stringsToMap.filter {"pid" in it.keys}.forEach {println(isValidPid(it["pid"].toString()))}
    /*


 var randomNumber = (1..10).random()
println(randomNumber)

  val oneStringMap = passportLists1.split("\\s".toRegex())
  val passportKeys1 = passportLists1.map { passport ->
      passport.flatMap { it.split(" ") }.map { it.split(":")[0] }.toSet()
  }
  println(passportLists1)


  val passportRequirements1 = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

  val validPassports1 = passportKeys1.count { it.containsAll(passportRequirements1) }

  println("Valid passports:  $validPassports1") */

}
