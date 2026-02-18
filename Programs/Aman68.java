public class Aman68 {
    public static void main(String[] args) {

        PrimeTillN(11);
    }

    public static void PrimeTillN(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println("" + i);
            }
        }
    }

    public static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
