package carracing.ui

import carracing.domain.Car

object ResultView {
    fun printCurrentPosition(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printStartMessage() {
        println("\n실행 결과")
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }
}
