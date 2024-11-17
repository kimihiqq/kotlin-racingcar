package carracing.strategy

fun interface Threshold {
    fun isSatisfied(value: Int): Boolean
}
