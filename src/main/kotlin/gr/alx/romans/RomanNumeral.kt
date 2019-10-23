package gr.alx.romans

class RomanNumeral {
    fun convert(number: Int): String {
        var roman = ""
        if (number in 1..9) {
            roman += convert1to9(number)
        } else if (number in 10..19) {
            roman += "X"
            roman += convert1to9(number - 10)
        } else if (number in 20..29) {
            roman += "XX"
            roman += convert1to9(number - 20)
        } else if (number in 30..39) {
            roman += "XXX"
            roman += convert1to9(number - 30)
        }
        return roman
    }

    private fun convert1to9(number: Int): String {
        var roman = ""
        if (number in 1..3) {
            roman += addIs(number)
        } else if (number == 4) {
            roman += "IV"
        } else if (number in 5..8) {
            roman += "V"
            roman += addIs(number - 5)
        } else if (number == 9) {
            roman += "IX"
        }
        return roman
    }

    private fun addIs(number: Int): String {
        var eyes = ""
        var index = 0
        while (index < number) {
            eyes += "I"
            index++
        }
        return eyes
    }
}
