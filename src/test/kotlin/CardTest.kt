import domain.Card
import domain.Gem
import org.junit.Assert
import org.junit.Test

class CardTest {

    @Test(expected = IllegalArgumentException::class)
    fun `When input invalid format - Should throw exception`() {
        Card.fromLine("2|green|[2,3,0,0,2]")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `When include unexpect character - Should throw exception`() {
        Card.fromLine("2.1|green|[2,3,0,0,2]")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `When include unexpect special character - Should throw exception`() {
        Card.fromLine("2.|1|green|[2,3,0,0,2]")
    }

    @Test
    fun `When input character filed gem - Should character is lower only`() {
        val subject = Card.fromLine("2|1|green|[2,3,0,0,2]")
        Assert.assertEquals(Gem.GREEN, subject.resource)
    }

    @Test
    fun `When input valid - Should be WBB`() {
        val card = Card.fromLine("2|1|green|[2,3,0,0,2]")

        Assert.assertNotNull(card)
        Assert.assertEquals(2, card.level)
        Assert.assertEquals(1, card.score)
        Assert.assertEquals(Gem.GREEN, card.resource)
        Assert.assertEquals(3, card.prices.size)

        Assert.assertEquals(2, card.prices[Gem.WHITE])
        Assert.assertEquals(3, card.prices[Gem.BLUE])
        Assert.assertEquals(2, card.prices[Gem.BLACK])
    }

    @Test
    fun `When input valid - Should be RGB`() {
        val card = Card.fromLine("2|2|black|[0,1,4,2,0]")

        Assert.assertNotNull(card)
        Assert.assertEquals(2, card.level)
        Assert.assertEquals(2, card.score)
        Assert.assertEquals(Gem.BLACK, card.resource)
        Assert.assertEquals(3, card.prices.size)

        Assert.assertEquals(2, card.prices[Gem.RED])
        Assert.assertEquals(4, card.prices[Gem.GREEN])
        Assert.assertEquals(1, card.prices[Gem.BLUE])
    }


}
