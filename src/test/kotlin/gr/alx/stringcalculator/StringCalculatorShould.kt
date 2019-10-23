package gr.alx.stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class StringCalculatorShould {

    @Test
    fun `should calculate 0 when passed empty string`() {
        assertThat(0).isEqualTo(StringCalculator().add(""))
    }

    @Test
    fun `should calculate 4 when passed '4'`() {
        assertThat(4).isEqualTo(StringCalculator().add("4"))
    }

    @Test
    fun `should calculate 3 when passed '1,2'`() {
        assertThat(3).isEqualTo(StringCalculator().add("1,2"))
    }

    @Test
    fun `should calculate 45 when passed '1,2,3,4,5,6,7,8,9'`() {
        assertThat(45).isEqualTo(StringCalculator().add("1,2,3,4,5,6,7,8,9"))
    }

    @Test
    fun `should calculate 6 when passed '1n2,3'`() {
        assertThat(6).isEqualTo(StringCalculator().add("1\n2,3"))
    }

    @Test
    fun `should calculate  3 when passed a separator and '1 separator 2`() {
        assertThat(3).isEqualTo(StringCalculator().add("//;\n1;2"))
    }

    @Test
    fun `should disallow negative numbers`() {
        val exception = assertFailsWith<IllegalArgumentException> { StringCalculator().add("1,-2,-3") }
        assertThat("negatives not allowed: -2, -3").isEqualTo(exception.message)
    }

    @Test
    fun `should ignore numbers over 1000`() {
        assertThat(2).isEqualTo(StringCalculator().add("1001,2"))
    }

    @Test
    fun `should use separator between brackets`() {
        assertThat(6).isEqualTo(StringCalculator().add("//[***]\n1***2***3"))

    }

    @Test
    fun `should support multiple separators each one between brackets`() {
        assertThat(6).isEqualTo(StringCalculator().add("//[*][%]\n1*2%3"))

    }

    @Test
    fun `should support multiple separators with any character length`() {
        assertThat(6).isEqualTo(StringCalculator().add("//[foo][bar]\n1foo2bar3"))

    }
}
