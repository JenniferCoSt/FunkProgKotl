package Aoc2020Dec04

import AdventReader

val path2 = "src/AoCData/AoC2020Dec04b"
val adventReader2 = AdventReader()

var adventInput2 = adventReader2.returnFile2(path2).joinToString("\n") //konverterar listan från List String för att kunna splitta den


fun splitNewline1(): List<String> {
    val regex = Regex("\n\n+")
    return adventInput1.split(regex)

}

fun main() {
    // gör en map av splitNewline()
    val passportLists1 = splitNewline().map { it.split("\n").toMutableList() }
    val passportKeys1 = passportLists1.map { passport ->
        passport.flatMap { it.split(" ") }.map { it.split(":")[0] }.toSet()
    }

    val passportRequirements1 = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    val validPassports1 = passportKeys1.count { it.containsAll(passportRequirements1) }

    println("Valid passports:  $validPassports1")

}
