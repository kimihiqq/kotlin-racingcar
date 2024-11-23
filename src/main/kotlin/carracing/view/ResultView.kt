package carracing.view

import carracing.dto.CarDto
import carracing.dto.RaceResult
import carracing.dto.RoundResult

object ResultView {
    fun printStartMessage() {
        println("\n실행 결과")
    }

    fun printResults(raceResult: RaceResult) {
        printAllRounds(raceResult.rounds)
        printWinners(raceResult.winners)
    }

    private fun printWinners(winners: List<CarDto>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("${winnerNames}가 최종 우승했습니다.")
    }

    private fun printAllRounds(allRounds: List<RoundResult>) {
        allRounds.forEach { roundResult ->
            printCurrentRound(roundResult)
        }
    }

    private fun printCurrentRound(round: RoundResult) {
        round.cars.forEach { carDTO ->
            println("${carDTO.name} : ${"-".repeat(carDTO.position)}")
        }
        println()
    }
}
