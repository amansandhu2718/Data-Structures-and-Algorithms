public class Aman2 {

    public static void main(String[] args) {

        int num = 1500000;
        System.out.println(convert(num));

    }

    public static String convert(int num) {
        if (num == 0) {
            return "zero";
        } else {
            return Helper(num);
        }
    }

    public static String Helper(int num) {

        if (num < 20) {

            return belowTwenty[num];
        }
        if (num < 100) {
            return tens[num / 10] + " " + belowTwenty[num % 10];
        }
        if (num < 1000) {
            return Helper(num / 100) + " hundred " + Helper(num % 100);
        }
        if (num < 100000) {
            return Helper(num / 1000) + " thousand " + Helper(num % 1000);
        }
        if (num < 10000000) {
            return Helper(num / 100000) + " lakh " + Helper(num % 100000);
        }

        return Helper(num / 10000000) + " crore " + Helper(num % 10000000);

    }

    private static final String[] belowTwenty = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };
    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

}
