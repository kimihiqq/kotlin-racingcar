package carracing.domain

import carracing.strategy.RandomGenerator
import carracing.strategy.Threshold
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RaceTest : StringSpec({
    val numberOfCars = 3
    val numberOfAttempts = 5
    val threshold = Threshold { it >= 4 }

    "race should move all cars when threshold is always satisfied" {
        val randomGenerator = RandomGenerator { 5 }
        val cars = List(numberOfCars) { Car("car$it", threshold) }
        val race = Race(cars, numberOfAttempts, randomGenerator)

        race.start()

        cars.forEach { car ->
            car.position shouldBe numberOfAttempts
        }
    }

    "race should not move any car when threshold is never satisfied" {
        val randomGenerator = RandomGenerator { 3 }
        val cars = List(numberOfCars) { Car("car$it", threshold) }
        val race = Race(cars, numberOfAttempts, randomGenerator)

        race.start()

        cars.forEach { car ->
            car.position shouldBe 0
        }
    }

    "race should respect the random generator and threshold logic" {
        val randomValues = mutableListOf(4, 5, 3, 6, 2, 4, 5, 3, 6, 2, 4, 5, 3, 6, 2)
        val randomGenerator = RandomGenerator { randomValues.removeFirst() }
        val cars = List(numberOfCars) { Car("car$it", threshold) }
        val race = Race(cars, numberOfAttempts, randomGenerator)

        race.start()

        cars.forEach { car ->
            car.position shouldBe 3
        }
    }
})
