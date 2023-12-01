import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        day1A();
        day1B();
    }

    public static void day1A() {
        String firstNumber = "";
        String lastNumber = "";
        String finalNumber = "";
        int finalNumberInt = 0;
        ArrayList<Integer> allNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AdventOfCode2023\\src\\inputs\\day1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (firstNumber.isEmpty()) {
                        if (Character.isDigit(line.charAt(i))) {
                            firstNumber = String.valueOf(line.charAt(i));
                        }
                    }
                    if (Character.isDigit(line.charAt(i))) {
                        lastNumber = String.valueOf(line.charAt(i));
                    }
                    if (lastNumber.isEmpty()) {
                        lastNumber = firstNumber;
                    }
                    if (i == line.length() - 1) {
                        finalNumber += firstNumber;
                        finalNumber += lastNumber;
                        allNumbers.add(Integer.valueOf(finalNumber));
                        firstNumber = "";
                        lastNumber = "";
                        finalNumber = "";
                    }
                }
            }
            for (Integer allNumber : allNumbers) {
                finalNumberInt += allNumber;
            }
            System.out.println(finalNumberInt);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void day1B() {
        int sumOfCalibrationValues = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kwint\\IdeaProjects\\AdventOfCode2023\\src\\inputs\\day1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Checking line: " + line);
                int firstDigit = -1;
                int lastDigit = -1;
                boolean foundFirstDigit = false;

                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLetter(line.charAt(i))) {
                        StringBuilder wordBuilder = new StringBuilder();
                        while (i < line.length() && Character.isLetter(line.charAt(i))) {
                            wordBuilder.append(line.charAt(i));
                            String word = wordBuilder.toString().toLowerCase();
                            i++;
                            System.out.println("Found word: " + word);
                            if (word.contains("one")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 1;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 1;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("two")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 2;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 2;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("three")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 3;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 3;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("four")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 4;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 4;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("five")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 5;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 5;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("six")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 6;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 6;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("seven")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 7;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 7;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("eight")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 8;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 8;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            } else if (word.contains("nine")) {
                                if (!foundFirstDigit) {
                                    firstDigit = 9;
                                    System.out.println("first digit is now " + firstDigit);
                                    foundFirstDigit = true;
                                }
                                lastDigit = 9;
                                System.out.println("last digit is now " + lastDigit);
                                wordBuilder.setLength(0);
                                wordBuilder.append(word.charAt(word.length() - 1));
                            }
                        }
                    }
                    if (i < line.length() && Character.isDigit(line.charAt(i))) {
                        int number = Character.getNumericValue(line.charAt(i));
                        System.out.println("Found digit from number: " + number);
                        if (!foundFirstDigit) {
                            firstDigit = number;
                            foundFirstDigit = true;
                        }
                        lastDigit = number;
                        System.out.println("last digit is now " + lastDigit);
                    }
                }
                if (firstDigit != -1 && lastDigit != -1) {
                    int calibrationValue = Integer.parseInt("" + firstDigit + lastDigit);
                    System.out.println("Calibration value for line: " + calibrationValue);
                    sumOfCalibrationValues += calibrationValue;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        System.out.println("Sum of all calibration values: " + sumOfCalibrationValues);
    }
}