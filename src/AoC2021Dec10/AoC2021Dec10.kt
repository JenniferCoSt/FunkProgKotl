package AoC2021Dec10

import AdventReader

//Advent of Code 10 December 2021
class AoC2021Dec10 {
    val pathC = "src/AoCData/AoC2021Dec10"
    val advRader = AdventReader()

    val advInput = advRader.returnData(pathC)

    //Tar emot listan med datat, går igenom varje rad i listan, skapar upp en Deque. Går sen in på varje tecken
    // i varje rad. När det är ett öppningstecken så läggs det i Dequen, annars kollas om tecknet är ett
    // korrumperat tecken. Om det är korrumperat så läggs tecknet i listan corruptedChars. break finns för
    //avbryta sökandet i befintliga raden eftersom vi endast ska kolla första korrumperade tecknet enligt
    // uppgiftsspecifikationen.
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

    //Tar in en Deque med chars och char att kontrollera från metod ovan. Om Dequen är tom så returneras true
    //(tecknet är korrumperat), annars kontrolleras inskickade tecknet mot det senaste tecknet i Dequen.
    //Om det inte matchar öppningstecknet så är tecknet korrumperat och metoden returnerar true,
    // annars returneras false.
    private fun isCorrupted(stack: ArrayDeque<Char>, closingChar: Char): Boolean {
        if (stack.isEmpty()) return true

        val openChar = stack.removeLast()
        return when (openChar) {
            '(' -> closingChar != ')'
            '[' -> closingChar != ']'
            '{' -> closingChar != '}'
            '<' -> closingChar != '>'
            else -> false
        }
    }

    //Listan med korrumperade tecken skickas in, för varje tecken kollas poäng och adderas till totalsumman
    // som sen returneras.
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