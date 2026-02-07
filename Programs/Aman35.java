public class Aman35 {
    public static void main(String[] args) {
        String str = "aman";
        ReverseString(str);
    }

    public static void ReverseString(String s) {

        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }

        System.out.println((new String(arr)));
    }
}
