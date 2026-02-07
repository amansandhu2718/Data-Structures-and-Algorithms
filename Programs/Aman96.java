
import java.util.HashMap;

public class Aman96 {
    // Find the length of the longest substring with all unique characters.

    public static void main(String[] args) {

        String s = "abcdeesk";
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        int max = 0;
        while (i < s.length()) {

            char ch = s.charAt(i);
            // add
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            // shrink
            while (mp.containsKey(ch) && mp.get(ch) > 1) {
                char left = s.charAt(j);
                mp.put(left, mp.get(left) - 1);
                if (mp.get(left) == 0) {
                    mp.remove(left);
                }
                j++;
            }
            // answer
            int count = (i - j) + 1;
            if (count > max) {
                max = count;
            }
            i++;
        }

        System.out.println(max);

    }

}
