import java.util.HashMap;

public class Aman101 {

    public static void main(String[] args) {
        int arr[] = new int[] { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(totalFruit(arr));
    }

    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<>(); // type -> count
        int j = 0;
        int maxLen = 0;
        for (int i = 0; i < fruits.length; i++) {
            // add to map
            if (mp.containsKey(fruits[i])) {
                mp.put(fruits[i], mp.get(fruits[i]) + 1);
            } else {
                mp.put(fruits[i], 1);
            }
            // if map > 2 reduce last

            while (mp.size() > 2 && j < fruits.length) {
                // if Jth element present and >=1 then reduce else remove finally j++

                if (mp.containsKey(fruits[j])) {

                    // if 0 or negative after reduce then remove
                    if (mp.get(fruits[j]) > 1) {

                        mp.put(fruits[j], mp.get(fruits[j]) - 1);
                    } else {

                        mp.remove(fruits[j]);
                    }
                    j++;
                } else {
                    continue;
                }
            }
            int len = i - j + 1;
            if (len > maxLen) {
                maxLen = len;
            }

        }
        return maxLen;
    }
}