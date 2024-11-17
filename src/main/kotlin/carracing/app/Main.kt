package carracing.app

import carracing.domain.Car
import carracing.domain.Race
import carracing.strategy.RandomGenerator
import carracing.strategy.Threshold
import carracing.ui.InputView
import carracing.ui.ResultView
import kotlin.random.Random

fun main() {
    val numberOfCars = InputView.getNumberOfCars()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    val threshold = Threshold { it >= 4 }
    val randomGenerator = RandomGenerator { Random.nextInt(0, 10) }

    val race = Race(List(numberOfCars) { Car(threshold) }, numberOfAttempts, randomGenerator)

    ResultView.printStartMessage()
    race.start()
}
