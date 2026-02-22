public class Aman224 {
    public static void main(String[] args) {

        int n = 10;
        System.out.println(Fibonacci(n, new int[n + 1]));
    }

    public static int Fibonacci(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int a = Fibonacci(n - 1, qb);
        int b = Fibonacci(n - 2, qb);
        int c = a + b;
        qb[n] = c;
        return c;
    }
}
