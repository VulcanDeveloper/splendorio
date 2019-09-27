import exception.GameInitialException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Game {

    private Collection<Card> deck;
    private Collection<Coin> coins = new ArrayList<>();
    private Player[] players;

    private static final int[] COIN_SIZE = {0, 4, 5, 7};

    private Collection<Coin> generateCoin(final Gem type, final int size) {
        return IntStream.range(0, size).mapToObj(idx -> new Coin(type)).collect(Collectors.toList());
    }

    public Game(final String... players) {
        if(players.length <= 1){
            throw new GameInitialException();
        }

        try {
            final int playerSize = players.length - 1;
            Path deckFilePath = Paths.get(Main.class.getClassLoader().getResource("deck.txt").toURI());
            deck = Files.lines(deckFilePath)
                    .map(Card::fromLine)
                    .collect(Collectors.toList());
            this.players = Stream.of(players)
                    .map(Player::new)
                    .collect(Collectors.toList())
                    .toArray(new Player[players.length]);
            coins.addAll(generateCoin(Gem.GREEN, COIN_SIZE[playerSize]));
            coins.addAll(generateCoin(Gem.WHITE, COIN_SIZE[playerSize]));
            coins.addAll(generateCoin(Gem.BLUE, COIN_SIZE[playerSize]));
            coins.addAll(generateCoin(Gem.RED, COIN_SIZE[playerSize]));
            coins.addAll(generateCoin(Gem.BLACK, COIN_SIZE[playerSize]));
            coins.addAll(generateCoin(Gem.YELLOW, 5));
        } catch (Exception e) {
            throw new GameInitialException();
        }
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