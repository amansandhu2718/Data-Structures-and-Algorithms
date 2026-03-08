import java.util.*;

public class Aman247 {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };

        System.out.println("Subsets:");
        printSubset(arr);

        System.out.println("\nSubsequences:");
        printSubsequence(arr);

        System.out.println("\nSubarrays:");
        printSubarray(arr);

        System.out.println("\nSubstring (Array Equivalent):");
        printSubstring(arr);
    }

    // 1. Print all Subsets (Power Set)
    public static void printSubset(int[] arr) {
        int n = arr.length;
        int total = 1 << n; // 2^n subsets

        for (int mask = 0; mask < total; mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("}");
        }
    }

    // 2. Print all Subsequences (Recursive)
    public static void printSubsequence(int[] arr) {
        generateSubsequence(arr, new ArrayList<>(), 0);
    }

    private static void generateSubsequence(int[] arr, List<Integer> current, int index) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Include element
        current.add(arr[index]);
        generateSubsequence(arr, current, index + 1);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude element
        generateSubsequence(arr, current, index + 1);
    }

    // 3. Print all Subarrays (Contiguous)
    public static void printSubarray(int[] arr) {
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                System.out.print("{ ");
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("}");
            }
        }
    }

    // 4. Print "Substring" equivalent for arrays (same as subarray)
    public static void printSubstring(int[] arr) {
        // For arrays, substring concept does not exist.
        // It is identical to subarray (contiguous sequence).
        printSubarray(arr);
    }

}