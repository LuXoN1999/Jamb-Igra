import kotlin.random.Random

class Dice{
    private var isLocked: Boolean = false
    private var currentValue: Int = 1
    fun roll():Int{
        var value = Random.nextInt(1,7)
        this.currentValue = value
        return value
    }
    fun lock(){ this.isLocked = true }
    fun unlock() { this.isLocked = false}
    fun getLockedStatus():Boolean { return this.isLocked }
    fun getCurrentValue():Int { return this.currentValue }
}