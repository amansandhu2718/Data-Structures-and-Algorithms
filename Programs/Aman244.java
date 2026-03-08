public class Aman244 {
    public static void main(String[] args) {
        String str = "AMN";
        PrintAbbrevations(str, "", 0, 0);
    }

    public static void PrintAbbrevations(String str, String asf, int count, int pos) {

        if (pos == str.length()) {

            if (count == 0) {
                System.out.println(asf);
            } else {
                System.out.println(asf + count);
            }
            return;
        }

        if (count > 0) { // both are yes calls
            PrintAbbrevations(str, asf + count + str.charAt(pos), 0, pos + 1);
        } else {
            PrintAbbrevations(str, asf + str.charAt(pos), 0, pos + 1);
        }
        PrintAbbrevations(str, asf, count + 1, pos + 1); // no call

    }
}
