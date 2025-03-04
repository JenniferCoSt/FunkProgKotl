import java.io.File


class AdventReader {
    fun returnData(path: String): List<String> = File(path).readLines()
}