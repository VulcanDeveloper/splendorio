import exception.GameInitialException
import domain.Coin
import domain.Game
import domain.Gem
import org.junit.Assert
import org.junit.Test

class GameTest {

    // model.Game('Golf','Jae','Pete','Ong','Bird')

    @Test(expected = GameInitialException::class)
    fun `When have a player greater than four - Should Throw Exception`() {
        Game("Golf", "Jae", "Pete", "Ong", "Bird")
    }

    @Test(expected = GameInitialException::class)
    fun `When have a player less than two - Should Throw Exception`() {
        Game("Golf")
    }
    @Test
    fun `When input four player - Should Initial Game with 7 coins each and 5 yellow coins, 90 cards, 4 players, 5 nobles`() {
        TODO("check 5 nobles")
        val subject = Game("Golf", "Jae", "Pete", "Ong")

        val greenCoins = filterCoins(subject.coins, Gem.GREEN)
        val whiteCoins = filterCoins(subject.coins, Gem.WHITE)
        val redCoins = filterCoins(subject.coins, Gem.RED)
        val blueCoins = filterCoins(subject.coins, Gem.BLUE)
        val blackCoins = filterCoins(subject.coins, Gem.BLACK)
        val yellowCoins = filterCoins(subject.coins, Gem.YELLOW)

        Assert.assertEquals(7, greenCoins.size)
        Assert.assertEquals(7, whiteCoins.size)
        Assert.assertEquals(7, redCoins.size)
        Assert.assertEquals(7, blueCoins.size)
        Assert.assertEquals(7, blackCoins.size)
        Assert.assertEquals(5, yellowCoins.size)

        Assert.assertEquals(90, subject.deck.size)

        Assert.assertEquals(4, subject.players.size)

        Assert.assertEquals("Golf", subject.players[0].name)
        Assert.assertEquals("Jae", subject.players[1].name)
        Assert.assertEquals("Pete", subject.players[2].name)
        Assert.assertEquals("Ong", subject.players[3].name)

    }

    @Test
    fun `When have three player - Should Initial Game with 5 coins each and 5 yellow coins, 90 cards, 3 players, 4 nobles`() {
        TODO("check 4 nobles")
        val subject = Game("Golf", "Jae", "Pete")

        val greenCoins = filterCoins(subject.coins, Gem.GREEN)
        val whiteCoins = filterCoins(subject.coins, Gem.WHITE)
        val redCoins = filterCoins(subject.coins, Gem.RED)
        val blueCoins = filterCoins(subject.coins, Gem.BLUE)
        val blackCoins = filterCoins(subject.coins, Gem.BLACK)
        val yellowCoins = filterCoins(subject.coins, Gem.YELLOW)

        Assert.assertEquals(5, greenCoins.size)
        Assert.assertEquals(5, whiteCoins.size)
        Assert.assertEquals(5, redCoins.size)
        Assert.assertEquals(5, blueCoins.size)
        Assert.assertEquals(5, blackCoins.size)
        Assert.assertEquals(5, yellowCoins.size)

        Assert.assertEquals(90, subject.deck.size)

        Assert.assertEquals(3, subject.players.size)

        Assert.assertEquals("Golf", subject.players[0].name)
        Assert.assertEquals("Jae", subject.players[1].name)
        Assert.assertEquals("Pete", subject.players[2].name)

    }

    @Test
    fun `When have two player  - Should Initial Game with 4 coins each and 5 yellow coins, 90 cards, 2 players, 3 nobles`() {
        TODO("check 3 nobles")
        val subject = Game("Golf", "Jae")

        val greenCoins = filterCoins(subject.coins, Gem.GREEN)
        val whiteCoins = filterCoins(subject.coins, Gem.WHITE)
        val redCoins = filterCoins(subject.coins, Gem.RED)
        val blueCoins = filterCoins(subject.coins, Gem.BLUE)
        val blackCoins = filterCoins(subject.coins, Gem.BLACK)
        val yellowCoins = filterCoins(subject.coins, Gem.YELLOW)

        Assert.assertEquals(4, greenCoins.size)
        Assert.assertEquals(4, whiteCoins.size)
        Assert.assertEquals(4, redCoins.size)
        Assert.assertEquals(4, blueCoins.size)
        Assert.assertEquals(4, blackCoins.size)
        Assert.assertEquals(5, yellowCoins.size)

        Assert.assertEquals(90, subject.deck.size)

        Assert.assertEquals(2, subject.players.size)
        Assert.assertEquals("Golf", subject.players[0].name)
        Assert.assertEquals("Jae", subject.players[1].name)
    }


    private fun filterCoins(coins: Collection<Coin>, type: Gem) = coins.filter { it.type === type }
}
