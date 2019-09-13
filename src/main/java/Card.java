import java.util.HashMap;
import java.util.Map;

public class Card {

    private final int level;
    private final int point;
    private final Gem resource;
    private final Map<Gem, Integer> price;


    public Card(int level, int point, Gem resource, int[] prices) {
        this.level = level;
        this.point = point;
        this.resource = resource;
        this.price = new HashMap<>();
        price.put(Gem.WHITE, prices[0]);
        price.put(Gem.BLUE, prices[1]);
        price.put(Gem.GREEN, prices[2]);
        price.put(Gem.RED, prices[3]);
        price.put(Gem.BLACK, prices[4]);
    }
}
