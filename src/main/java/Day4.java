import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    public static void main(String[] args) {
//        Day4A();
        Day4B();
    }

    public static void Day4A() {
        String text = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53\n" +
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19\n" +
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1\n" +
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83\n" +
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36\n" +
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11";

        List<Card> cards = new ArrayList<>();
        int val = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AoC2023\\src\\inputs\\day4.txt"));
            for (String str : reader.lines().collect(Collectors.toList())) {
                cards.add(new Card(str));
            }

            for (Card c : cards) {
                val += c.getPoints();
            }

            System.out.println(val);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Day4B() {
        String text = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53\n" +
                "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19\n" +
                "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1\n" +
                "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83\n" +
                "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36\n" +
                "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11";

        List<Card> cards = new ArrayList<>();
        int val = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AoC2023\\src\\inputs\\day4.txt"));
            for (String str : reader.lines().collect(Collectors.toList())) {
                cards.add(new Card(str));
            }

            for (int i = 0; i < cards.size(); i++) {
                Card c = cards.get(i);
                int copies = c.getCopies();
                int wins = c.getWins();
                val += copies;
                for (int v = i + 1; v < i + 1 + wins && v < cards.size(); v++) {
                    cards.get(v).addCopies(copies);
                }
            }

            System.out.println(val);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}