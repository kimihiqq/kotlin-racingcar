package carracing.ui

object InputView {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readln()
        val carNames = input.split(",").map { it.trim() }

        require(carNames.all { it.length in 1..5 }) {
            "자동차 이름은 1자 이상, 5자 이하만 가능합니다."
        }
        return carNames
    }

    fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
