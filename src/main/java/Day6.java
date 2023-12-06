import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;

public class Day6 {

    public static void main(String[] args) {
        Day6();
    }

    public static void Day6() {
        String text = "Time:      7  15   30\n" +
                "Distance:  9  40  200";

        String puzzle = "Time:        61     67     75     71\n" +
                "Distance:   430   1036   1307   1150";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AoC2023\\src\\inputs\\day6.txt"));
            int val = 0;

            BigInteger num1 = new BigInteger("430103613071150");
            val = numberOfTimesToBeat(61677571, num1);
            System.out.println(val);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int numberOfTimesToBeat(int time, BigInteger record) {
        int ways = 0;
        for (int i = 1; i < time; i++) {
            if (BigInteger.valueOf(i).multiply(BigInteger.valueOf(Math.max(time - i, i - time))).compareTo(record) > 0) {
                ways++;
            }
        }
        return ways;
    }
}
