
import java.util.HashSet;

public class Aman143 {
    // Happy Number
    public static void main(String[] args) {
        System.out.println(isHappy(12));
    }

    public static boolean isHappy(int n) {

        HashSet<Integer> hs = new HashSet<>();

        while (n != 1 && !hs.contains(n)) {
            hs.add(n);
            // System.out.println(n);
            int sum = 0;
            int m = n;
            while (m > 0) {
                int quo = m % 10;
                System.out.println("quo:" + quo);
                sum = sum + (quo * quo);
                m = m / 10;
            }

            n = sum;
        }

        return n == 1;
    }
}
