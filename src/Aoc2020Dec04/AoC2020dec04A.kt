package Aoc2020Dec04

import AdventReader

val path1 = "src/AoCData/AoC2020Dec04"
val adventReader1 = AdventReader()

var adventInput1 = adventReader1.returnFile(path1).joinToString("\n") //konverterar listan från
// List String till String och splittar den, varje rad från filen separeras med en newline.

fun splitNewline(): List<String> { //denna metod använder Regular Expression för att dela upp strängen där det finns två
    val regex = Regex("\n\n") //eller fler newlines. Där delas passen upp mellan varandra.
    return adventInput1.split(regex) //detta blir en lista med varje pass som en sträng i listan.
}

fun main(){
    // gör en map av splitNewline()
    val passportLists = splitNewline().map{it.split("\n").toMutableList()} //skpar en lista av pass-strängar. map gör varje pass till en lista på en egen rad.
    val passportKeys = passportLists.map{ passport ->// flatmapen delar varje rad till individuella key:values
        passport.flatMap { it.split(" ")}.map{it.split(":")[0]}.toSet() // map-en extraherar bara Keys.
    } //toSet konverterar listan till en set, för att skapa unika nycklar.


    val passportRequirements = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid") //skapar en lista av de obligatoriska fälten

    val validPassports=passportKeys.count{it.containsAll(passportRequirements)} //räknar ut antal pass som har de obligatoriska fälten

    println("Valid passports:  $validPassports") //skriver ut antal godkända pass


}