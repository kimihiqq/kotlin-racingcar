class Calculator {
    fun calculate(input: String?): Int {
        require(!input.isNullOrBlank()) { "입력값이 null 이거나 빈 공백 문자 입니다." }
        val values = input.trim().split(" ")

        var result = values[0].toInt()
        for (i in 1 until values.size step 2) {
            val operator = values[i]
            val next = values[i + 1].toInt()
            result = calculate(result, operator, next)
        }
        return result
    }

    private fun calculate(
        first: Int,
        operator: String,
        second: Int,
    ): Int {
        return when (operator) {
            "+" -> first + second
            "-" -> first - second
            "*" -> first * second
            "/" -> first / second
            else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }
}
