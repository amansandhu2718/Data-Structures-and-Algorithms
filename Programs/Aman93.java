import java.util.HashMap;

public class Aman93 {
    // Given a string s and pattern p, count how many substrings of size len(p) are
    // anagrams of p.

    public static void main(String[] args) {

        // String s = "abcbcdedbca";
        // String p = "abc";
        String s = "aabaabaa";
        String p = "aaba";

        HashMap<Character, Integer> mymap = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (mymap.containsKey(ch)) {
                mymap.put(ch, mymap.get(ch) + 1);
            } else {
                mymap.put(ch, 1);
            }
        }

        int i = 0;
        int j = 0;
        int k = p.length();

        while (i < k) {
            char ch = s.charAt(i);
            if (mymap.containsKey(ch)) {
                mymap.put(ch, mymap.get(ch) - 1);
            }
            i++;
        }
        if (isAnagram(mymap)) {
            System.out.println("ans: " + j + " " + (i - 1));
        }

        while (i < s.length()) {

            // add
            char ch = s.charAt(i);
            if (mymap.containsKey(ch)) {
                mymap.put(ch, mymap.get(ch) - 1);
            }

            // remove
            char ch2 = s.charAt(j);
            if (mymap.containsKey(ch2)) {
                mymap.put(ch2, mymap.get(ch2) + 1);
            }
            // check

            // after
            i++;
            j++;
            if (isAnagram(mymap)) {
                System.out.println("ans: " + j + " " + (i - 1));
            }
        }

    }

    public static boolean isAnagram(HashMap<Character, Integer> mymap) {

        for (char key : mymap.keySet()) {
            if (mymap.get(key) > 0 || mymap.get(key) < 0) {
                return false;
            }
        }
        return true;
    }
}
