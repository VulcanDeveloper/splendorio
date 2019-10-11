import exception.GameInitialException
import org.junit.Assert
import org.junit.Test

class GameTest {

    // Game('Golf','Jae','Pete','Ong','Bird')

    @Test(expected = GameInitialException::class)
    fun `When have a player greater than four - Should Throw Exception`() {
        Game("Golf", "Jae", "Pete", "Ong", "Bird")
    }

    @Test(expected = GameInitialException::class)
    fun `When have a player less than two - Should Throw Exception`() {
        Game("Golf")
    }
    @Test
    fun `When have four player - Success`() {
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
    fun `When have three player - Success`() {
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
    fun `When have two player - Success`() {
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
