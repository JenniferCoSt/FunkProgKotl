package AoC2021Dec10

import AdventReader

class AoC2021Dec10 {
    val pathC = "src/AoCData/AoC2021Dec10"
    val advRader = AdventReader()

    val advInput = advRader.returnData(pathC)


    fun findCorruptedChar(dataList: List<String>): List<Char> {
        val corruptedChars = mutableListOf<Char>()

        val pairs = mapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{',
            '>' to '<'
        )

        for (line in dataList) {
            val stack = ArrayDeque<Char>()

            for (char in line) {
                when {
                    char in "([{<" -> stack.addLast(char)
                    char in ")]}>" -> {
                        if (stack.isEmpty() || stack.removeLast() != pairs[char]) {
                            corruptedChars.add(char)
                            break
                        }
                    }
                }
            }
        }
        return corruptedChars
    }



    fun getScore(chars: List<Char>): Int {
        var totalScore = 0

        for (char in chars) {
            when (char) {
                ')' -> totalScore += 3
                ']' -> totalScore += 57
                '}' -> totalScore += 1197
                '>' -> totalScore += 25137
            }
        }
        return totalScore
    }

}

fun main() {
    val advent = AoC2021Dec10()

    val charsList = advent.findCorruptedChar(advent.advInput)
    print(advent.getScore(charsList))
}