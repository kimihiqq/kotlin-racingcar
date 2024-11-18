package carracing.app

import carracing.domain.Car
import carracing.domain.Race
import carracing.strategy.RandomGenerator
import carracing.strategy.Threshold
import carracing.view.InputView
import carracing.view.ResultView
import kotlin.random.Random

fun main() {
    val carNames = InputView.getCarNames()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    val threshold = Threshold { it >= 4 }
    val randomGenerator = RandomGenerator { Random.nextInt(0, 10) }
    val cars = carNames.map { Car(it, threshold) }
    val race = Race(cars, numberOfAttempts, randomGenerator)

    ResultView.printStartMessage()
    race.start()
    ResultView.printWinners(race.findWinners())
}
