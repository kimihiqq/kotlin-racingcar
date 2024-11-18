package carracing.domain

import carracing.strategy.Threshold

class Car(
    val name: String,
    private val threshold: Threshold,
) {
    var position: Int = 0
        private set

    fun move(value: Int) {
        if (threshold.isSatisfied(value)) {
            position++
        }
    }
}
