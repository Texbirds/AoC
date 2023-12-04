import java.util.ArrayList;
import java.util.List;

public class Card {

    int cardNumber;
    int points;
    List<Integer> winning = new ArrayList<>();

    int wins = 0;
    int copies = 1;

    public Card(String str) {
        String[] arr = str.split(":");
        cardNumber = Integer.parseInt(arr[0].replace("Card" , "").trim());
        String[] arr2 = arr[1].split("\\|");
        for (String string : arr2[0].split(" ")) {
            if (string.isEmpty()) {
                continue;
            }
            winning.add(Integer.parseInt(string));
        }
        for (String string : arr2[1].split(" ")) {
            if (string.isEmpty()) {
                continue;
            }
            if (winning.contains(Integer.parseInt(string))) {
                wins++;
                if (points == 0) {
                    points++;
                } else {
                    points *= 2;
                }
            }
        }
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getCopies() {
        return copies;
    }

    public void addCopies(int copies) {
        this.copies += copies;
    }
}
