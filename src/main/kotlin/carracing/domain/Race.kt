package carracing.domain

import carracing.dto.RaceResult
import carracing.dto.RoundResult

class Race(
    private val cars: List<Car>,
    private val attempts: Int,
    private val randomGenerator: RandomGenerator,
) {
    fun start(): RaceResult {
        val allRounds =
            buildList {
                repeat(attempts) {
                    moveCars()
                    add(RoundResult(cars.map { it.toDto() }))
                }
            }

        val winners = findWinners().map { it.toDto() }
        return RaceResult(allRounds, winners)
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move(randomGenerator.generate())
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
