package calculator

sealed class Operator {
    abstract fun apply(
        num1: Int,
        num2: Int,
    ): Int

    companion object {
        fun of(symbol: String): Operator {
            return when (symbol) {
                "+" -> Add
                "-" -> Subtract
                "*" -> Multiply
                "/" -> Divide
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }
    }

    object Add : Operator() {
        override fun apply(
            num1: Int,
            num2: Int,
        ): Int = num1 + num2
    }

    object Subtract : Operator() {
        override fun apply(
            num1: Int,
            num2: Int,
        ): Int = num1 - num2
    }

    object Multiply : Operator() {
        override fun apply(
            num1: Int,
            num2: Int,
        ): Int = num1 * num2
    }

    object Divide : Operator() {
        override fun apply(
            num1: Int,
            num2: Int,
        ): Int {
            require(num2 != 0) { "0으로 나눌 수 없습니다." }
            return num1 / num2
        }
    }
}
