class CombinationChecker(private val allDice: List<Dice>) {
    private var countOf1 = this.checkCountOfValuesInList(1)
    private var countOf2 = this.checkCountOfValuesInList(2)
    private var countOf3 = this.checkCountOfValuesInList(3)
    private var countOf4 = this.checkCountOfValuesInList(4)
    private var countOf5 = this.checkCountOfValuesInList(5)
    private var countOf6 = this.checkCountOfValuesInList(6)

    fun isSmallStraight():Boolean{
        if(countOf1 > 0 && countOf2 > 0 && countOf3 > 0 && countOf4 > 0){
            return true
        }
        else if(countOf2 > 0 && countOf3 > 0 && countOf4 > 0 && countOf5 > 0){
            return true
        }
        else if(countOf3 > 0 && countOf4 > 0 && countOf5 > 0 && countOf6 > 0){
            return true
        }
        return false
    }

    fun isLargeStraight():Boolean{
        if(countOf1 > 0 && countOf2 > 0 && countOf3 > 0 && countOf4 > 0 && countOf5 > 0){
            return true
        }
        else if(countOf2 > 0 && countOf3 > 0 && countOf4 > 0 && countOf5 > 0 && countOf6 > 0){
            return true
        }
        return false
    }

    fun isJumb():Boolean{
        if(countOf1 == 5 || countOf2 == 5 || countOf3 == 5 || countOf4 == 5 || countOf5 == 5 || countOf6 == 5){
            return true
        }
        return false
    }

    private fun checkCountOfValuesInList(value: Int): Int{
        var counter = 0
        for(dice in allDice){
            if(value == dice.getCurrentValue()){
                counter++
            }
        }
        return counter
    }

    fun sumOfDiceValues(): Int{
        return countOf1*1 + countOf2*2 + countOf3*3 + countOf4*4 + countOf5*5 + countOf6*6
    }
}