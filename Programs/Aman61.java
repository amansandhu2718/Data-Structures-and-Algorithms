public class Aman61 {
    public static void main(String[] args) {
        int n = 100;
        int k = 3;
        System.out.println(Solve(n, k) + 1);
    }

    public static int Solve(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int x = Solve(n - 1, k);
        int y = (x + k) % n;
        return y;
    }

    public static int solveIterative(int n, int k) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }
        return result;
    }
}
