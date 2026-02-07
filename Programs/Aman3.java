public class Aman3 {
    
    /**
     * 
     * int to Roman
     * @param args
     */
    public static void main(String[] args) {
        int num =3456;
        System.out.println(Convert(num));   // Output: LXVII
    }

    public static String Convert(int num) {

        String s = "";

        s += convertGroup(num / 1000, "M", "", "");
        num %= 1000;

        s += convertGroup(num / 100, "C", "D", "M");
        num %= 100;

        s += convertGroup(num / 10, "X", "L", "C");
        num %= 10;

        s += convertGroup(num, "I", "V", "X");

        return s;
    }

    public static String convertGroup(int num, String min, String mid, String max) {

        String result = "";

        if (num == 0) return "";

        // 1, 2, 3 → min repeated
        if (num <= 3) {
            for (int i = 0; i < num; i++) {
                result += min;
            }
            return result;
        }

        // 4 → min + mid
        if (num == 4) {
            result=min + mid;
            return result;
        }

        // 5 → mid
        if (num == 5) {
            result=mid;
            return result;
        }

        // 6, 7, 8 → mid + (min repeated)
        if (num <= 8) {
            result += mid;
            for (int i = 0; i < num - 5; i++) {
                result += min;
            }
            return result;
        }

        // 9 → min + max
        if (num == 9) {
            result= min + max;
            return result;
        }

        return "";
    }
}


