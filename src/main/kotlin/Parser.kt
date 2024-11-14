package calculator

object Parser {
    fun parse(input: String?): Pair<List<Int>, List<Operator>> {
        require(!input.isNullOrBlank()) { "입력값이 null 이거나 빈 공백 문자 입니다." }
        val values = input.trim().split(" ")

        val numbers = values.filterIndexed { index, _ -> index % 2 == 0 }.map { it.toInt() }
        val operators = values.filterIndexed { index, _ -> index % 2 == 1 }.map { Operator.of(it) }
        return Pair(numbers, operators)
    }
}
