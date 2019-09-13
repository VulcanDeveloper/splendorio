import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try {
            Path deckFilePath = Paths.get(Main.class.getClassLoader().getResource("deck.txt").toURI());
            Files.lines(deckFilePath).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
