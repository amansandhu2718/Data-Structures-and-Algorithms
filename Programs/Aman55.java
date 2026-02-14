public class Aman55 {

    public static void main(String[] args) {
        PrintPermutation("abc", "");
    }

    public static void PrintPermutation(String q, String ans) {
        if (q.length() == 0) {
            System.out.println(ans);
        }

        for (int i = 0; i < q.length(); i++) {
            char ch = q.charAt(i);
            String ledt = q.substring(0, i);
            String right = q.substring(i + 1);
            PrintPermutation(ledt + right, ans + ch);
        }
    }
}
