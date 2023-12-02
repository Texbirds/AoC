import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    public static void main(String[] args) {
        Day2A();
        Day2B();
    }

    public static void Day2A() {
        int total = 0;
        int i = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AoC2023\\src\\inputs\\day2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    boolean possible = true;
                    String[] subsets = parts[1].split(";");

                    for (String subset : subsets) {
                        String[] cubes = subset.trim().split(", ");

                        for (String cube : cubes) {
                            String[] partsCube = cube.split(" ");
                            if (partsCube.length == 2) {
                                int count;
                                try {
                                    count = Integer.parseInt(partsCube[0]);
                                } catch (NumberFormatException e) {
                                    possible = false;
                                    break;
                                }

                                if (count > 14 || (partsCube[1].equals("green") && count > 13) || (partsCube[1].equals("red") && count > 12)) {
                                    possible = false;
                                    break;
                                }
                            } else {
                                possible = false;
                                break;
                            }
                        }

                        if (!possible) {
                            break;
                        }
                    }

                    if (possible) {
                        total += i;
                    }
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Sum of IDs of possible games: " + total);
    }

    public static void Day2B() {
        int lowestCountRed = Integer.MIN_VALUE;
        int lowestCountGreen = Integer.MIN_VALUE;
        int lowestCountBlue = Integer.MIN_VALUE;

        int total = 0;
        int wholeTotal = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AoC2023\\src\\inputs\\day2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String[] subsets = parts[1].split(";");

                        for (String subset : subsets) {
                            String[] cubes = subset.trim().split(", ");

                            for (String cube : cubes) {
                                String[] partsCube = cube.split(" ");
                                if (partsCube.length == 2) {
                                    int count;
                                    try {
                                        count = Integer.parseInt(partsCube[0]);
                                    } catch (NumberFormatException e) {
                                        break;
                                    }

                                    if ((count > lowestCountRed && partsCube[1].equals("red"))) {
                                        lowestCountRed = count;
                                    } else if (count > lowestCountGreen && partsCube[1].equals("green")) {
                                        lowestCountGreen = count;
                                    } else if (count > lowestCountBlue && partsCube[1].equals("blue")) {
                                        lowestCountBlue = count;
                                    }
                                }
                            }
                        }
                    }
                    total = total + lowestCountRed * lowestCountBlue * lowestCountGreen;
                    wholeTotal += total;
                    lowestCountRed = Integer.MIN_VALUE;
                    lowestCountGreen = Integer.MIN_VALUE;
                    lowestCountBlue = Integer.MIN_VALUE;
                    total = 0;
                }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        System.out.println("Sum of the power of these sets: " + wholeTotal);
    }
}

