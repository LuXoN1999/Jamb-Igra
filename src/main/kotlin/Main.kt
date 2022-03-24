fun main(args: Array<String>) {
    val player1 = Player("Igrac123")
    val player2 = Player("IgracABC")
    var repeatGame = true
    val game = Game(player1,player2)
    while(repeatGame){
        game.start()
        print("Do you want to start a new game?(y/n): ")
        if(readLine() == "n"){
            repeatGame = false
        }
    }
}

fun String.intOrString(): Boolean {
    return when(toIntOrNull()) {
        null -> false
        else -> true
    }
}