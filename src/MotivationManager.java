import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MotivationManager {
    private final List<String> quotes = Arrays.asList(
        "Small steps every day lead to big changes.",
        "You do not have to be perfect; just keep going.",
        "Make today a little more beautiful than yesterday."
    );

    public String chooseQuote() {
        String quote = quotes.get(new Random().nextInt(quotes.size()));
        System.out.println("4. Daily motivation: \"" + quote + "\"");
        return quote;
    }
}
