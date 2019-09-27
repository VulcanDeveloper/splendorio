public class Coin {


    private final Gem type;

    public Coin(Gem type) {
        this.type = type;
    }

    public Gem getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "type=" + type +
                '}';
    }
}
