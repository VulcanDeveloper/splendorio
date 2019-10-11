import exception.GameInitialException

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.ArrayList
import java.util.stream.Collectors
import java.util.stream.IntStream
import java.util.stream.Stream

class Game(vararg players: String) {

    val deck: Collection<Card>
    val coins: List<Coin>
    val players: List<Player>


    private fun generateCoin(type: Gem, size: Int) = (1..size).map { Coin(type) }

    init {

        if (players.size <= 1) {
            throw GameInitialException()
        }

        try {
            val deckFilePath = Paths.get(this.javaClass.classLoader.getResource("deck.txt").toURI())

            deck = Files.lines(deckFilePath)
                    .map { Card.fromLine(it) }
                    .collect(Collectors.toList())

            this.players = players.map { Player(it) }
            val coinSize = COIN_SIZE[players.size] ?: error("Player size invalid")
            val green =  generateCoin(Gem.GREEN, coinSize)
            val white =  generateCoin(Gem.WHITE, coinSize)
            val blue =  generateCoin(Gem.BLUE, coinSize)
            val red =  generateCoin(Gem.RED, coinSize)
            val black =  generateCoin(Gem.BLACK, coinSize)
            val yellow =  generateCoin(Gem.YELLOW, 5)

            this.coins = green + white + blue + red + black + yellow

        } catch (e: Exception) {
            throw GameInitialException()
        }

    }

    companion object {

        private val COIN_SIZE = mapOf(2 to 4, 3 to 5, 4 to 7)
    }
}