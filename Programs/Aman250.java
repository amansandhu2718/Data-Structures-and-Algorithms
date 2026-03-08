import java.util.*;

public class Aman250 {

    static String word1 = "SEND";
    static String word2 = "MORE";
    static String result = "MONEY";

    static Set<Character> uniqueLetters = new LinkedHashSet<>();
    static Map<Character, Integer> charToDigit = new HashMap<>();
    static boolean[] usedDigits = new boolean[10];

    public static void main(String[] args) {
        // Collect unique letters
        for (char c : (word1 + word2 + result).toCharArray()) {
            uniqueLetters.add(c);
        }

        // Convert set to list for indexing
        List<Character> letters = new ArrayList<>(uniqueLetters);

        if (solve(letters, 0)) {
            printSolution();
        } else {
            System.out.println("No solution found.");
        }
    }

    static boolean solve(List<Character> letters, int index) {
        // Base case: all letters assigned
        if (index == letters.size()) {
            return isValid();
        }

        char current = letters.get(index);

        for (int digit = 0; digit <= 9; digit++) {

            // Skip used digits
            if (usedDigits[digit])
                continue;

            // Leading letter cannot be zero
            if ((current == word1.charAt(0) ||
                    current == word2.charAt(0) ||
                    current == result.charAt(0)) && digit == 0)
                continue;

            // Assign digit
            charToDigit.put(current, digit);
            usedDigits[digit] = true;

            // Recur
            if (solve(letters, index + 1))
                return true;

            // Backtrack
            charToDigit.remove(current);
            usedDigits[digit] = false;
        }

        return false;
    }

    static boolean isValid() {
        int num1 = convertToNumber(word1);
        int num2 = convertToNumber(word2);
        int res = convertToNumber(result);

        return num1 + num2 == res;
    }

    static int convertToNumber(String word) {
        int value = 0;
        for (char c : word.toCharArray()) {
            value = value * 10 + charToDigit.get(c);
        }
        return value;
    }

    static void printSolution() {
        System.out.println("Solution:");
        for (Map.Entry<Character, Integer> entry : charToDigit.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\nVerification:");
        System.out.println(convertToNumber(word1) + " + " +
                convertToNumber(word2) + " = " +
                convertToNumber(result));
    }
}