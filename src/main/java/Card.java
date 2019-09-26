import java.util.HashMap;
import java.util.Map;

public class Card {

    private final int level;
    private final int score;
    private final Gem resource;
    private final Map<Gem, Integer> price;

    private Card(int level, int score, Gem resource, Map prices) {
        this.level = level;
        this.score = score;
        this.resource = resource;
        this.price = prices;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public Gem getResource() {
        return resource;
    }

    public Map<Gem, Integer> getPrice() {
        return price;
    }

    //2|1|green|[2,3,0,0,2]
    //int level, int score, Gem resource, int[] prices
    public static Card fromLine(final String line) {

        String[] splitedString = line.split("\\|");
        Gem gem = null;
        switch (splitedString[2].toLowerCase()) {
            case "white":
                gem = Gem.WHITE;
                break;
            case "blue":
                gem = Gem.BLUE;
                break;
            case "green":
                gem = Gem.GREEN;
                break;
            case "red":
                gem = Gem.RED;
                break;
            case "black":
                gem = Gem.BLACK;
                break;
        }

        String[] priceSplit = splitedString[3].substring(1, splitedString[3].length() - 1).split(",");
        Map<Gem, Integer> price = new HashMap();
        price.put(Gem.WHITE, Integer.parseInt(priceSplit[0]));
        price.put(Gem.BLUE, Integer.parseInt(priceSplit[1]));
        price.put(Gem.BLACK, Integer.parseInt(priceSplit[4]));

        Card result = new Card(Integer.parseInt(splitedString[0]), Integer.parseInt(splitedString[1]), gem, price);
        return result;
    }
}
