package calculator

class Calculator {
    fun calculate(input: String?): Int {
        val (numbers, operators) = Parser.parse(input)
        var result = numbers[0]
        for (i in 1 until numbers.size) {
            val operator = operators[i - 1]
            result = operator.apply(result, numbers[i])
        }
        return result
    }
}
