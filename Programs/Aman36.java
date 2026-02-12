public class Aman36 {
    public static void main(String[] args) {

        String actualString = "aman";
        String typedString = "aaamaaaannnn";
        System.out.println(longPressed(actualString, typedString));
    }

    public static boolean longPressed(String actualString, String typedString) {

        int i = 0;
        int j = 0;
        int prevI = 0;
        while (j < typedString.length() && i < actualString.length()) {

            if (actualString.charAt(i) == typedString.charAt(j)) {
                prevI = i;
                i++;
                j++;
            } else if (typedString.charAt(j) == actualString.charAt(prevI)) {
                j++;
            } else {
                return false;
            }
        }

        while (j < typedString.length()) {
            if (typedString.charAt(j) != actualString.charAt(prevI)) {
                return false;
            } else {
                j++;
            }
        }
        return j == typedString.length() && i == actualString.length();
    }
}
