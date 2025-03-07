package TomtelandJen/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"

Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)

Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydande som en given person har
Exempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"

För att bli godkänd på uppgiften måste du använda rekursion.

 */

class TomtelandJ {

    fun getTomteHierarchyJ(): Map<String, List<String>> {

        val tomteMap = mapOf("Tomten" to listOf("Glader", "Butter"),
            "Glader" to listOf("Tröger", "Trötter", "Blyger"),
            "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
            "Räven" to listOf("Gråsuggan", "Myran"),
            "Trötter" to listOf("Skumtomten"),
            "Myran" to listOf("Bladlusen"),
            "Skumtomten" to listOf("Dammråttan")
        )

        return tomteMap
    }


    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlingsJ(currentName: String?, res: MutableList<String>): List<String> {
        if(currentName == null) return res
        val getEntry = getTomteHierarchyJ().filter{it.key == currentName}

        res.addAll(getEntry.values.flatten())
        getEntry.values.flatten().forEach{ getUnderlingsJ(it, res) }

        return res
    }
}

fun main() {

    //Exempel på anrop till den rekursiva funktionen getUnderlings,
    // här är tanken att hitta Tröger underlydande
    //listan fylls på successivt när vi rekurserar
    val tomteland = TomtelandJ()

    var butterList: MutableList<String> = mutableListOf()
    println(tomteland.getUnderlingsJ("Butter", butterList))
    var skumtomtenList: MutableList<String> = mutableListOf()
    println(tomteland.getUnderlingsJ("Skumtomten", skumtomtenList))

}