package AoC2021Dec10

import AdventReader

class AoC2021Dec10 {
    val pathC = "src/AoCData/AoC2021Dec10"
    val advRader = AdventReader()

    val advInput = advRader.returnData(pathC)


    fun findCorruptedChars(dataList: List<String>): List<Char> {
        val corruptedChars = mutableListOf<Char>()

        for (line in dataList) {
            val stack = ArrayDeque<Char>()

            for (char in line) {
                when (char) {
                    '(', '[', '{', '<' -> stack.addLast(char)
                    ')', ']', '}', '>' -> if (isCorrupted(stack, char)) {
                        corruptedChars.add(char)
                        break
                    }
                }
            }
        }
        return corruptedChars
    }

    fun isCorrupted(stack: ArrayDeque<Char>, char: Char): Boolean {
        if (stack.isEmpty()) return true

        val openChar = stack.removeLast()
        return !findMatchingChar(openChar, char)
    }

    fun findMatchingChar(openChar: Char, closeChar: Char): Boolean {
        return when (openChar) {
            '(' -> closeChar == ')'
            '[' -> closeChar == ']'
            '{' -> closeChar == '}'
            '<' -> closeChar == '>'
            else -> false
        }
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

    val charsList = advent.findCorruptedChars(advent.advInput)
    print(advent.getScore(charsList))
}