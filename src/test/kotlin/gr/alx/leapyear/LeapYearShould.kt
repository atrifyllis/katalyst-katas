package gr.alx.leapyear

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LeapYearShould {

    @ParameterizedTest
    @CsvSource("1995", "1997")
    fun `categorize as normal year`(year: Int) {
        assertThat(false).isEqualTo(LeapYear().check(year))
    }

    @ParameterizedTest
    @CsvSource("1996", "2004")
    fun `categorize divisible by 4 as leap year`(year: Int) {
        assertThat(true).isEqualTo(LeapYear().check(year))
    }

    @ParameterizedTest
    @CsvSource("1600", "2000")
    fun `categorize divisible by 400 as leap year`(year: Int) {
        assertThat(true).isEqualTo(LeapYear().check(year))
    }

    @ParameterizedTest
    @CsvSource("1800", "1400")
    fun `categorize divisible by 4, divisible by 100, NOT divisible by 400 as normal year`(year: Int) {
        assertThat(false).isEqualTo(LeapYear().check(year))
    }
}
