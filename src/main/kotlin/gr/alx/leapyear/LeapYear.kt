package gr.alx.leapyear

class LeapYear {
    fun check(year: Int): Boolean {
        if (year.isDivisibleBy(4)) {
            if (year.isDivisibleBy(100) && year.isNotDivisibleBy(400)) {
                return false
            }
            return true
        }
        return false
    }

    private fun Int.isDivisibleBy(year: Int) = this % year == 0
    private fun Int.isNotDivisibleBy(year: Int) = this % year != 0

}
