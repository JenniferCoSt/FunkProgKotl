package AoC2020Dec06

import AdventReader

class AoC2020Dec06 {
    val pathS = "src/AoCData/AoC2020Dec6"
    val adventReader = AdventReader()

    val adventInput = adventReader.returnData(pathS)

    fun returnMap(adventList: List<String>): Map<Int, List<String>> {
        var adventMap = mutableMapOf<Int, List<String>>()
        var tempList = mutableListOf("")
        var counter = 1

        for(l in adventList){
            tempList.add(l)
            if(l.length == 0 || l == adventList.last()){
                adventMap.put(counter, tempList.toList())
                counter++
                tempList.clear()
            }
        }
        return adventMap
    }

    fun returnDistinctAnswersInGroup(inputMap: Map<Int, List<String>>): Map<Int, Set<Char>> {
        var mapSet = mutableMapOf<Int, Set<Char>>()
        var counter = 1
        for (l in inputMap.values) {
            var linesSet = l.flatMap {it.toSet()}.toSet()
            mapSet.put(counter, linesSet)
            counter++
        }
        return mapSet
    }

    fun countYesAnswers(answersMap: Map<Int, Set<Char>>): Int {
        var totalYesAnswers = 0
        for(c in answersMap.values) {
            totalYesAnswers += c.size
        }
        return totalYesAnswers
    }
}

fun main() {
    val advent = AoC2020Dec06()
    //val aMap = advent.returnMap(advent.adventInput)
    //val bMap = advent.returnDistinctAnswersInGroup(aMap)
    println(advent.countYesAnswers(advent.returnDistinctAnswersInGroup(advent.returnMap(advent.adventInput))))
}