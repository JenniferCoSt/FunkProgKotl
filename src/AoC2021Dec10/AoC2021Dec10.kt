package AoC2021Dec10

import AdventReader

class AoC2021Dec10 {
    val pathC = "src/AoCData/AoC2021Dec10"
    val advRader = AdventReader()

    val advInput = advRader.returnData(pathC)

    fun findCompleteLines(inputList: List<String>): List<String> {
        var completedLines = mutableListOf<String>()
        for (line in inputList) {
            if (line.length % 2 != 0){
                completedLines.add(line)
            }
        }
        return completedLines
    }

    //In progress
    fun findCorruptingChar(corruptList: List<String>): Map<Char, Int> {
        var corruptedMap = mutableMapOf<Char, Int>()

        for (line in corruptList) {
            line.toSet()


        }
        return corruptedMap
    }


}