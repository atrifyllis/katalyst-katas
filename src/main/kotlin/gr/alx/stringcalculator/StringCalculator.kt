package gr.alx.stringcalculator

class StringCalculator {
    fun add(numbers: String): Int {
        if (numbers == "") {
            return 0
        }
        val separators = extractSeparators(numbers)
        val processedList = processNumbers(numbers, separators)
        return if (processedList.all { it > 0 }) processedList.sum()
        else throw IllegalArgumentException(
                "negatives not allowed: ${processedList.filter { it < 0 }.joinToString()}"
        )
    }

    private fun processNumbers(numbers: String, separators: List<String>): List<Int> {
        return removePrefixes(numbers, separators)
                .split(*separators.toTypedArray())
                .map { it.toInt() }
                .filter { it <= 1000 }
    }

    private fun removePrefixes(numbers: String, separators: List<String>): String {
        var processedNumbers = numbers
                .removePrefix(SEPARATOR_PREFIX)
        for (separator in separators) {
            processedNumbers = processedNumbers.removePrefix("[${separator}]")
            processedNumbers = processedNumbers.removePrefix(separator)
        }
        return processedNumbers.removePrefix(NEW_LINE)
    }

    private fun extractSeparators(numbers: String): List<String> {
        val defaultSeparators = listOf<String>(",", NEW_LINE)
        if (!isNewSeparatorDefined(numbers)) {
            return defaultSeparators
        }
        val startOfSeparator = numbers.substring(2, 3)
        return if (isSingleCharSeparator(startOfSeparator)) {
            listOf(*defaultSeparators.toTypedArray(), startOfSeparator)
        } else {
            augmentSeparators(defaultSeparators, numbers)
        }
    }


    private fun augmentSeparators(defaultSeparators: List<String>, numbers: String): MutableList<String> {
        val augmentedSeparators = mutableListOf<String>(*defaultSeparators.toTypedArray())
        for ((index, value) in numbers.withIndex()) {
            if (value.toString() == MULTI_CHAR_SEPARATOR_START) {
                augmentedSeparators.add(extractMultiCharSeparator(numbers, index))
            }
        }
        return augmentedSeparators
    }

    private fun isNewSeparatorDefined(numbers: String) = numbers.startsWith(SEPARATOR_PREFIX)

    private fun isSingleCharSeparator(startOfSeparator: String) = startOfSeparator != MULTI_CHAR_SEPARATOR_START


    private fun extractMultiCharSeparator(numbers: String, index: Int) =
            numbers.substring(index + 1, numbers.indexOf(MULTI_CHAR_SEPARATOR_END, index))

    companion object {
        const val SEPARATOR_PREFIX = "//"
        const val MULTI_CHAR_SEPARATOR_START = "[";
        const val MULTI_CHAR_SEPARATOR_END = "]";
        const val NEW_LINE = "\n";
    }
}
