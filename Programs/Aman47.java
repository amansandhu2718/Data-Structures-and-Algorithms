public class Aman47 {
    public static void main(String[] args) {
        // longest common prefix
        String str[] = { "flower", "flow", "flight" };

        StringBuilder res = new StringBuilder();
        int i = 0;
        boolean allOK = true;
        while (i < str[0].length()) {
            char ch = str[0].charAt(i);
            allOK = true;
            for (int j = 1; j < str.length; j++) {

                if (i < str[j].length() && str[j].charAt(i) == ch) {

                } else {
                    allOK = false;
                    break;
                }

            }

            if (allOK) {
                res = res.append(ch);
            } else {
                break;
            }
            i++;
        }
        System.out.println(res);

    }
}
