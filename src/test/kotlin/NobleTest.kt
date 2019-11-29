import domain.Gem
import domain.Noble
import org.junit.Assert
import org.junit.Test

class NobleTest {
    @Test
    fun `When input valid line, should return valid noble object`(){
        val noble = Noble.fromLine("A1|3|[0,0,4,4,0]")

        Assert.assertEquals( "A1", noble.name);
        Assert.assertEquals( 3, noble.score);
        Assert.assertEquals(4, noble.prices[Gem.GREEN]);
        Assert.assertEquals(4, noble.prices[Gem.RED]);
        Assert.assertEquals(2, noble.prices.size);
    }

    @Test(expected = IllegalArgumentException::class)
    fun `When input invalid line, should throw IllegalArgumentException`(){
        Noble.fromLine("A1|[0,0,4,4,0]")
    }
}