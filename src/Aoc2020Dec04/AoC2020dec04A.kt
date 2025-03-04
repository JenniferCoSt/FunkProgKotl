package Aoc2020Dec04

import AdventReader

val path1 = "src/AoCData/AoC2020Dec04"
val adventReader1 = AdventReader()

var adventInput1 = adventReader1.returnFile(path1).joinToString("\n") //konverterar listan från List String för att kunna splitta den

fun splitNewline(): List<String> {
    val regex = Regex("\n\n+")
    return adventInput1.split(regex)
}

fun main(){
    // gör en map av splitNewline()
    val passportLists = splitNewline().map{it.split("\n").toMutableList()}
    val passportKeys = passportLists.map{ passport ->
        passport.flatMap { it.split(" ")}.map{it.split(":")[0]}.toSet()
    }

    val passportRequirements = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    val validPassports=passportKeys.count{it.containsAll(passportRequirements)}

    println("Valid passports:  $validPassports")


}