import java.util.ArrayList;
import java.util.List;

public class Aman48 {

    public static String codes[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void main(String[] args) {
        List<String> res = letterCombinationsEcursive("23", 0);
        for (String string : res) {
            System.out.println(string);
        }
    }

    public static List<String> letterCombinations(String digits) {
        return letterCombinationsEcursive(digits, 0);
    }

    public static List<String> letterCombinationsEcursive(String digits, int index) {
        System.out.println(index);
        if (index == digits.length()) {
            List<String> res2 = new ArrayList<>();
            res2.add("");

            return res2;
        }
        char ch = digits.charAt(index);
        int codeIndex = ch - '0';

        String code = codes[codeIndex];

        List<String> str = letterCombinationsEcursive(digits, index + 1);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            for (int j = 0; j < code.length(); j++) {
                res.add(code.charAt(j) + "" + str.get(i));
            }
        }

        return res;

    }

}
