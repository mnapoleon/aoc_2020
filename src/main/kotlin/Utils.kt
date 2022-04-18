class Utils {

    companion object{
        fun getResourceAsText(path: String): List<String>? =
            object {}.javaClass.getResource(path)?.readText()?.split("\n")
    }
}