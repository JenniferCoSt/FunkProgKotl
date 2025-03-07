package KarinaTomteland


open class TomtelandK {

    val tomteMap: Map<String, List<String>> = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )
    
    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlingsK(currentName: String, res: MutableList<String>): List<String> {
        val underlings = tomteMap[currentName] //kollar upp i Map String List.
        //om currentname, som värde finns i mapen, blir underlings en stränglista med dess underhuggare.

        if (underlings == null) { //om det inte finns några underhuggare returneras null [].
            return res //rekursionen stannar
        }
        val newSubordinates = underlings

        for (subordinates in newSubordinates) {
            res.add(subordinates) //lägger till en underhuggare i taget
        }

        for (subordinates in newSubordinates) { //den här kallar på underhuggare igen, för att vissa underhuggare
            getUnderlingsK(subordinates, res) //har andra underhuggare och itereras tills det inte finns någon kvar.
        }

        return res //när rekursionen är klar returnerars en lista av alla samlade underhuggare.
    }

}
    fun main() {
        val tomteland = TomtelandK()

        val list: MutableList<String> = mutableListOf()
        println(tomteland.getUnderlingsK("Tröger", list))
        println(tomteland.getUnderlingsK("Skumtomten", list))

    }




