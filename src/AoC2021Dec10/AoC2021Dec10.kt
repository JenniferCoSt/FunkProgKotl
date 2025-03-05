package AoC2021Dec10

import AdventReader

//Advent of Code 10 December 2021
class AoC2021Dec10 {
    val pathC = "src/AoCData/AoC2021Dec10"
    val advRader = AdventReader()

    val advInput = advRader.returnData(pathC)

    //Tar emot listan med datat, går igenom varje rad i listan, skapar upp en Deque. Går sen in på varje tecken
    // i varje rad. När det är ett öppningstecken så läggs det i Dequen, annars kollas om det är ett korrumperat
    //tecken. Om det är korrumperat så läggs tecknet i Dequen.
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

    private fun isCorrupted(stack: ArrayDeque<Char>, char: Char): Boolean {
        if (stack.isEmpty()) return true

        val openChar = stack.removeLast()
        return when (openChar) {
            '(' -> char != ')'
            '[' -> char != ']'
            '{' -> char != '}'
            '<' -> char != '>'
            else -> false
        }
    }

 /*   private fun findMatchingChar(openChar: Char, closeChar: Char): Boolean {

    }

  */

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

    //val charsList = advent.findCorruptedChars(advent.advInput)
    //print(advent.getScore(charsList))
    println(advent.getScore(advent.findCorruptedChars(advent.advInput)))
}