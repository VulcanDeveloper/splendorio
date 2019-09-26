import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Card> deck;
    private Collection<Coin> coins = new ArrayList<>();
    private Player[] players;

    public Game(final int playerNumber) {

    }

    public Collection<Card> getDeck() {
        return deck;
    }

    public Collection<Coin> getCoins() {
        return coins;
    }

    public Player[] getPlayers() {
        return players;
    }
}