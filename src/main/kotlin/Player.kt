class Player(private var name: String) {
    fun rollUnlockedDice(allDice: List<Dice>) {
        for(dice in allDice){
            if(!dice.getLockedStatus()){
                dice.roll()
            }
        }
    }

    fun chooseDiceToLock(): String{
        var choice: String = readLine().toString()
        return choice
    }

    fun getName(): String { return this.name }
}