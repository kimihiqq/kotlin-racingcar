package carracing.domain

import carracing.strategy.RandomGenerator
import carracing.ui.ResultView

class Race(
    private val cars: List<Car>,
    private val attempts: Int,
    private val randomGenerator: RandomGenerator,
) {
    fun start() {
        repeat(attempts) {
            moveCars()
            ResultView.printCurrentPosition(cars)
        }
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
