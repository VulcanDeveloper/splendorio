import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test(expected = IllegalArgumentException.class)
    public void test_whenInputInvalidFormat_shouldThrowException() {
        Card.fromLine("2|green|[2,3,0,0,2]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_whenIncludeUnexpectCharacter_shouldThrowException() {
        Card.fromLine("2.1|green|[2,3,0,0,2]");
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_whenIncludeUnexpectSpecialCharacter_shouldThrowException() {
        Card.fromLine("2.|1|green|[2,3,0,0,2]");
    }

    @Test
    public void test_whenInputCharacterFiledGem_shouldCharacterIsLowerOnly() {
        Card subject = Card.fromLine("2|1|green|[2,3,0,0,2]");
        Assert.assertEquals(Gem.GREEN, subject.getResource());
    }

    @Test
    public void test_whenInputValidWBB() {
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

    @Test
    public void test_whenInputValidRGB() {
        Card card = Card.fromLine("2|2|black|[0,1,4,2,0]");

        Assert.assertNotNull(card);
        Assert.assertEquals(2, card.getLevel());
        Assert.assertEquals(2, card.getScore());
        Assert.assertEquals(Gem.BLACK, card.getResource());
        Assert.assertEquals(3, card.getPrice().size());

        Assert.assertEquals(2, card.getPrice().get(Gem.RED).longValue());
        Assert.assertEquals(4, card.getPrice().get(Gem.GREEN).longValue());
        Assert.assertEquals(1, card.getPrice().get(Gem.BLUE).longValue());
    }




}
