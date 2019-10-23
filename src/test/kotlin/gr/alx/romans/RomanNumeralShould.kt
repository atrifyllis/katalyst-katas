package gr.alx.romans

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RomanNumeralShould {

    @Test
    fun `should convert 1 to I`() {
        assertThat("I").isEqualTo(RomanNumeral().convert(1))
    }

    @Test
    fun `should convert 2 to II`() {
        assertThat("II").isEqualTo(RomanNumeral().convert(2))
    }

    @Test
    fun `should convert 3 to III`() {
        assertThat("III").isEqualTo(RomanNumeral().convert(3))
    }

    @Test
    fun `should convert 4 to IV`() {
        assertThat("IV").isEqualTo(RomanNumeral().convert(4))
    }

    @Test
    fun `should convert 5 to V`() {
        assertThat("V").isEqualTo(RomanNumeral().convert(5))
    }

    @Test
    fun `should convert 6 to VI`() {
        assertThat("VI").isEqualTo(RomanNumeral().convert(6))
    }

    @Test
    fun `should convert 7 to VII`() {
        assertThat("VII").isEqualTo(RomanNumeral().convert(7))
    }

    @Test
    fun `should convert 8 to VIII`() {
        assertThat("VIII").isEqualTo(RomanNumeral().convert(8))
    }

    @Test
    fun `should convert 9 to IX`() {
        assertThat("IX").isEqualTo(RomanNumeral().convert(9))
    }

    @Test
    fun `should convert 10 to X`() {
        assertThat("X").isEqualTo(RomanNumeral().convert(10))
    }

    @Test
    fun `should convert 11 to XI`() {
        assertThat("XI").isEqualTo(RomanNumeral().convert(11))
    }

    @Test
    fun `should convert 24 to XXIV`() {
        assertThat("XXIV").isEqualTo(RomanNumeral().convert(24))
    }

    @Test
    fun `should convert 39 to XXXIX`() {
        assertThat("XXXIX").isEqualTo(RomanNumeral().convert(39))
    }
}
