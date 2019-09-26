import org.junit.Assert;
import org.junit.Test;

public class CardTest {

//    2.1|green|[2,3,0,0,2]

    @Test(expected = IllegalArgumentException.class)
    public void test_whenInputInvalidFormat_shouldThrowException() {
        Card.fromLine("2|green|[2,3,0,0,2]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_whenIncludeUnexpectCharacter_shouldThrowException() {
        Card.fromLine("2.1|green|[2,3,0,0,2]");
    }

    @Test
    public void test_whenInputValid() {
        Card card = Card.fromLine("2|1|green|[2,3,0,0,2]");

        Assert.assertNotNull(card);
        Assert.assertEquals(2, card.getLevel());
        Assert.assertEquals(1, card.getScore());
        Assert.assertEquals(Gem.GREEN, card.getResource());
        Assert.assertEquals(3, card.getPrice().size());

        Assert.assertEquals(2, card.getPrice().get(Gem.WHITE).longValue());
        Assert.assertEquals(3, card.getPrice().get(Gem.BLUE).longValue());
        Assert.assertEquals(2, card.getPrice().get(Gem.BLACK).longValue());
    }

}
