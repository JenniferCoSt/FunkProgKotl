package AoC2020Dec06

import AdventReader

class AoC2020Dec06 {
    val pathS = "src/AoCData/AoC2020Dec6"
    val adventReader = AdventReader()

    val adventInput = adventReader.returnData(pathS)

    //Omvandlar listan med data till en Map med en Int som key och value består av en lista med strängar.
    //Den grupperar listor efter Enter-slag. Eller om det är sista raden så skapar den en sista grupp, se if-sats.
    fun returnMap(adventList: List<String>): Map<Int, List<String>> {
        var adventMap = mutableMapOf<Int, List<String>>()
        var tempList = mutableListOf("")
        var counter = 1

        for (line in adventList) {
            tempList.add(line)
            if (line.length == 0 || line == adventList.last()) {
                adventMap.put(counter, tempList.toList())
                counter++
                tempList.clear()
            }
        }
        return adventMap
    }

    //Tar in en Map, från metod ovan. För varje value(lista av strängar) flatmappar den och skapar ett set
    // av Chars. Ny counter för Int som key och för value sparas de unika Charsen i varje set.
    fun returnDistinctAnswersInGroup(inputMap: Map<Int, List<String>>): Map<Int, Set<Char>> {
        var mapSet = mutableMapOf<Int, Set<Char>>()
        var counter = 1
        for (line in inputMap.values) {
            var linesSet = line.flatMap { it.toSet() }.toSet()
            mapSet.put(counter, linesSet)
            counter++
        }
        return mapSet
    }

    //Läser in en Map, från metoden ovan. För varje value kollar den value-storlek och adderar.
    // Returnerar värdet av summan som är svaret på AoC 6 Dec 2020.
    fun countYesAnswers(answersMap: Map<Int, Set<Char>>) = answersMap.values.sumOf { it.size }
}

    fun main() {
        val advent = AoC2020Dec06()
        //prinln nedan kan delas upp i aMap och bMap
        //val aMap = advent.returnMap(advent.adventInput)
        //val bMap = advent.returnDistinctAnswersInGroup(aMap)

        println(advent.countYesAnswers(advent.returnDistinctAnswersInGroup(advent.returnMap(advent.adventInput))))
    }
