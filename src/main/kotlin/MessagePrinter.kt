class MessagePrinter {
    private fun printAllDiceValues(allDice: List<Dice>){
        for((diceIndex, dice) in allDice.withIndex()){
            println("Dice [$diceIndex] -> ${dice.getCurrentValue()}")
        }
    }

    private fun printAllDicesLockedStatus(allDice: List<Dice>){
        for ((diceIndex, dice) in allDice.withIndex()){
            if(dice.getLockedStatus()){
                println("Dice [$diceIndex] LOCKED -> ${dice.getCurrentValue()}")
            }
            else{
                println("Dice [$diceIndex] FREE -> ${dice.getCurrentValue()}")
            }
        }
    }

    fun printEndingResults(allDice: List<Dice>){
        this.separate()
        println("ENDING RESULT:")
        this.printAllDiceValues(allDice)
    }

    fun askPlayerForDiceLocking(player: Player){
        print("${player.getName()},enter index of dice which you want to LOCK(Enter X to continue) or enter C to cancel\nChoose: ")
    }

    fun printThrowResults(numberOfRound: Int, allDice: List<Dice>){
        this.separate()
        println("Throw $numberOfRound.")
        this.printAllDicesLockedStatus(allDice)
    }

    fun printGameScores(player1: Player, playerScore1: Int,player2: Player, playerScore2: Int){
        this.separate()
        println("NAME: ${player1.getName()}\t POINTS: $playerScore1")
        println("NAME: ${player2.getName()}\t POINTS: $playerScore2")
    }

    fun printWinner(player: Player?){
        this.separate()
        if(player==null){
            println("THE GAME ENDED IN A DRAW!")
        }
        else{
            println("${player.getName()} IS WINNER!")
        }
    }

    private fun separate(){
        println("============================================================")
    }
}