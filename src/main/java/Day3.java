import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day3 {

    public static void main(String[] args) {
        Day3A();
//        Day3ATest();
    }

    public static void Day3A() {
        String text = "12.......*..\n" +
                "+.........34\n" +
                ".......-12..\n" +
                "..78........\n" +
                "..*....60...\n" +
                "78.........9\n" +
                ".5.....23..$\n" +
                "8...90*12...\n" +
                "............\n" +
                "2.2......12.\n" +
                ".*.........*\n" +
                "1.1..503+.56";

        Map<String, Integer> characters = new HashMap<>();
        characters.put("*", 1);
        characters.put("#", 2);
        characters.put("+", 3);
        characters.put("$", 4);
        characters.put("&", 5);
        characters.put("-", 6);
        characters.put("%", 7);
        characters.put("=", 8);
        characters.put("/", 9);
        characters.put("@" , 10);

        int[] map = new int[150 * 150];

        int val = 0;
        int x = 0;
        int y = 0;

        List<Position> list = new ArrayList<>();
        Position np = null;

        Arrays.fill(map, 0);

        // text.split("\n")
        //reader.lines().collect(Collectors.toList())
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AoC2023\\src\\inputs\\day3.txt"))) {
            for (String line : reader.lines().collect(Collectors.toList())) {
                for (String c : line.split("")) {
                    if (Character.isDigit(c.charAt(0))) {
                        if (np == null) {
                            np = new Position();
                        }
                        np.addNumber(x, y, c);
                    } else {
                        if (np != null) {
                            list.add(np);
                        }
                        np = null;
                    }
                    
                    if (characters.containsKey(c)) {
                        map[y * 150 + x] = characters.get(c);
                    } else if (!c.equals(".") && !Character.isDigit(c.charAt(0))) {
                        System.out.println(c);
                    }
                    x++;
                }
                x = 0;
                y++;
            }

            for (Position np2 : list) {
                if (np2.isAdjacent(map)) {
                    val += np2.getNumber();
                }
            }

            printMap(map);
            System.out.println(val);
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printMap(int[] map) {
        for(int y = 0; y < 150; y++) {
            for (int x = 0; x < 150; x++) {
                if (map[y * 150 + x] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(map[y * 150 + x]);
                }
            }
            System.out.println();
        }
    }
}
