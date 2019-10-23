package gr.alx.fizzbuzz

class FizzBuzz {
    fun convert(number: Int): String {
        var result = ""
        if (number % 3 == 0) result += "Fizz"
        if (number % 5 == 0) result += "Buzz"
        if (result.isEmpty()) result = number.toString()
        return result
    }
}
