import exception.GameInitialException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.stream.Collectors;

public class GameTest {


    @Test(expected = GameInitialException.class)
    public void test_WhenHaveAPlayerGreaterThanFour_ShouldThrowException() {
        new Game(5);
    }

    @Test(expected = GameInitialException.class)
    public void test_WhenHaveAPlayerLessThanTwo_ShouldThrowException() {
        new Game(1);
    }

    @Test
    public void test_WhenHaveFourPlayer() {
        Game subject = new Game(4);

        Collection<Coin> greenCoins = filterCoins(subject.getCoins(), Gem.GREEN);
        Collection<Coin> whiteCoins = filterCoins(subject.getCoins(), Gem.WHITE);
        Collection<Coin> redCoins = filterCoins(subject.getCoins(), Gem.RED);
        Collection<Coin> blueCoins = filterCoins(subject.getCoins(), Gem.BLUE);
        Collection<Coin> blackCoins = filterCoins(subject.getCoins(), Gem.BLACK);
        Collection<Coin> yellowCoins = filterCoins(subject.getCoins(), Gem.YELLOW);

        Assert.assertEquals(7, greenCoins.size());
        Assert.assertEquals(7, whiteCoins.size());
        Assert.assertEquals(7, redCoins.size());
        Assert.assertEquals(7, blueCoins.size());
        Assert.assertEquals(7, blackCoins.size());
        Assert.assertEquals(5, yellowCoins.size());

        Assert.assertEquals(90, subject.getDeck().size());

        Assert.assertEquals(4, subject.getPlayers().length);
    }

    @Test
    public void test_WhenHaveThreePlayer() {
        Game subject = new Game(3);

        Collection<Coin> greenCoins = filterCoins(subject.getCoins(), Gem.GREEN);
        Collection<Coin> whiteCoins = filterCoins(subject.getCoins(), Gem.WHITE);
        Collection<Coin> redCoins = filterCoins(subject.getCoins(), Gem.RED);
        Collection<Coin> blueCoins = filterCoins(subject.getCoins(), Gem.BLUE);
        Collection<Coin> blackCoins = filterCoins(subject.getCoins(), Gem.BLACK);
        Collection<Coin> yellowCoins = filterCoins(subject.getCoins(), Gem.YELLOW);

        Assert.assertEquals(5, greenCoins.size());
        Assert.assertEquals(5, whiteCoins.size());
        Assert.assertEquals(5, redCoins.size());
        Assert.assertEquals(5, blueCoins.size());
        Assert.assertEquals(5, blackCoins.size());
        Assert.assertEquals(5, yellowCoins.size());

        Assert.assertEquals(90, subject.getDeck().size());

        Assert.assertEquals(3, subject.getPlayers().length);
    }

    @Test
    public void test_WhenHaveTwoPlayer() {
        Game subject = new Game(2);

        Collection<Coin> greenCoins = filterCoins(subject.getCoins(), Gem.GREEN);
        Collection<Coin> whiteCoins = filterCoins(subject.getCoins(), Gem.WHITE);
        Collection<Coin> redCoins = filterCoins(subject.getCoins(), Gem.RED);
        Collection<Coin> blueCoins = filterCoins(subject.getCoins(), Gem.BLUE);
        Collection<Coin> blackCoins = filterCoins(subject.getCoins(), Gem.BLACK);
        Collection<Coin> yellowCoins = filterCoins(subject.getCoins(), Gem.YELLOW);

        Assert.assertEquals(4, greenCoins.size());
        Assert.assertEquals(4, whiteCoins.size());
        Assert.assertEquals(4, redCoins.size());
        Assert.assertEquals(4, blueCoins.size());
        Assert.assertEquals(4, blackCoins.size());
        Assert.assertEquals(5, yellowCoins.size());

        Assert.assertEquals(90, subject.getDeck().size());

        Assert.assertEquals(2, subject.getPlayers().length);
    }


    private Collection<Coin> filterCoins(final Collection<Coin> coins, final Gem type) {
        return coins
                .stream()
                .filter(c -> c.getType() == type)
                .collect(Collectors.toList());
    }
}
