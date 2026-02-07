public class Aman90 {
    // Given a string and integer k, find the maximum number of vowels in any
    // substring of length k.
    public static void main(String[] args) {
        String arr = "aasfjasfaokhasf";
        int k = 3;

        int i = 0, j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while (i < k) {
            if (isVowel(arr.charAt(i))) {
                sum = sum + 1;
            }
            i++;
        }
        max = sum;

        while (i < arr.length()) {

            if (isVowel(arr.charAt(i))) {
                sum = sum + 1;
            }

            if (isVowel(arr.charAt(j))) {
                sum = sum - 1;
            }

            if (sum > max) {
                max = sum;
            }
            j++;
            i++;
        }
        System.out.println("ans: " + max);
    }

    public static boolean isVowel(char ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}
