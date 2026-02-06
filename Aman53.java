public class Aman53 {
    public static void main(String[] args) {

        Toh(3, "a", "b", "c");
    }

    public static void Toh(int n, String t1, String t2, String t3) {
        if (n == 0) {
            return;
        }
        Toh(n - 1, t1, t3, t2);
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        Toh(n - 1, t3, t2, t1);
    }
}
