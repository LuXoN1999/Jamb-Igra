class Game(private val player1: Player, private val player2: Player) {
    private val allDice: List<Dice>
    private val messagePrinter : MessagePrinter
    private var player1Score = 0
    private var player2Score = 0

    init {
        val dice0 = Dice()
        val dice1 = Dice()
        val dice2 = Dice()
        val dice3 = Dice()
        val dice4 = Dice()
        val dice5 = Dice()
        this.allDice = listOf(dice0,dice1,dice2,dice3,dice4,dice5)
        this.messagePrinter = MessagePrinter()
    }

    fun start() {
        this.letPlayerPlayRound(player1)
        player1Score=checkCombinationReturnPoints()
        this.unlockAllDice()
        this.letPlayerPlayRound(player2)
        player2Score=this.checkCombinationReturnPoints()
        messagePrinter.printGameScores(player1,player1Score,player2,player2Score)
        messagePrinter.printWinner(this.checkWinner())

    }

    private fun lockDice(diceIndex: Int){
        this.allDice[diceIndex].lock()
    }

    private fun checkCombinationReturnPoints(): Int{
        val combinationChecker = CombinationChecker(allDice)
        if(combinationChecker.isLargeStraight()){
            return 40
        }
        else if(combinationChecker.isSmallStraight()){
            return 30
        }
        else if(combinationChecker.isJumb()){
            return 50
        }
        return combinationChecker.sumOfDiceValues()
    }

    private fun unlockAllDice(){
        for(dice in allDice){
            dice.unlock()
        }
    }

    private fun letPlayerPlayRound(player: Player){
        var stopRound = false
        var userChoice: String
        var roundCounter = 1
        while(roundCounter <= 3){
            player.rollUnlockedDice(allDice)
            messagePrinter.printThrowResults(roundCounter,allDice)
            messagePrinter.askPlayerForDiceLocking(player)
            do{
                userChoice = player.chooseDiceToLock()
                if(userChoice.intOrString()){
                    this.lockDice(userChoice.toInt())
                }
                if(userChoice=="C"){
                    stopRound = true
                    break
                }
            }while(userChoice != "X")
            if(stopRound){
                break
            }
            roundCounter++
        }
        messagePrinter.printEndingResults(this.allDice)
    }

    private fun checkWinner(): Player?{
        if(player1Score > player2Score){
            return player1
        }
        else if(player2Score > player1Score){
            return player2
        }
        return null
    }
}