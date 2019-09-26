import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        try {
//            Path deckFilePath = Paths.get(Main.class.getClassLoader().getResource("deck.txt").toURI());
//            Files.lines(deckFilePath).forEach(System.out::println);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String xx  = "2|3|white|[6,0,0,0,0]";
        String[] card  = xx.split("\\|");
        card[3] = card[3].substring(1,card[3].length()-1);
        List<String> list = Arrays.asList(card[3].split(","));

        System.out.println(list);
    }
}
