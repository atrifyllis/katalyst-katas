package gr.alx.fizzbuzz

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class FizzBuzzShould {

    @ParameterizedTest
    @CsvSource("1,1", "2,2", "4,4", "13,13", "14,14")
    fun `convert  number to string`(input: Int, expectedOutput: String) {
        assertThat(expectedOutput).isEqualTo(FizzBuzz().convert(input))
    }

    @ParameterizedTest
    @CsvSource("3", "6", "9", "12")
    fun `convert multiples of 3 to Fizz`(input: Int) {
        assertThat("Fizz").isEqualTo(FizzBuzz().convert(input))
    }

    @ParameterizedTest
    @CsvSource("5", "10", "20")
    fun `convert multiples of 5 to Buzz`(input: Int) {
        assertThat("Buzz").isEqualTo(FizzBuzz().convert(input))
    }

    @ParameterizedTest
    @CsvSource("15", "30", "45")
    fun `convert multiples of 3 and 5 to FizzBuzz`(input: Int) {
        assertThat("FizzBuzz").isEqualTo(FizzBuzz().convert(input))
    }

}
