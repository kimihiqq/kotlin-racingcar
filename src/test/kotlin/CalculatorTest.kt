import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `연산 테스트`() {
        val result = calculator.calculate("3 + 2 - 3 * 4 / 2")
        assertThat(result).isEqualTo(4)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 null이거나 빈 공백 문자일 경우`(input: String?) {
        assertThatThrownBy { calculator.calculate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값이 null 이거나 빈 공백 문자 입니다.")
    }

    @Test
    fun `사칙연산 기호가 아닌 경우`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculator.calculate("1 @ 2") }
            .withMessage("사칙연산 기호가 아닙니다.")
    }
}
