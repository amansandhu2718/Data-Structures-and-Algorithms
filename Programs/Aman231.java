import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aman231 {
    public static void main(String[] args) {
        String arr[][] = new String[][] {
                { "A", "C" },
                { "B", "C" },
                { "C", "F" },
                { "D", "E" },
                { "E", "F" },
                { "F", "F" },
        };

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String root = "";
        for (int i = 0; i < arr.length; i++) {
            String emp = arr[i][0];
            String manager = arr[i][1];
            if (emp.equals(manager)) {
                root = emp;
            }
            if (!emp.equals(manager)) {
                if (map.containsKey(manager)) {
                    ArrayList<String> list = map.get(manager);
                    list.add(emp);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(emp);
                    map.put(manager, list);
                }
            }
        }

        // System.out.println(map);
        // System.out.println(root);
        Print(map, root);
    }

    public static int Print(HashMap<String, ArrayList<String>> map, String key) {

        ArrayList<String> arr = map.get(key);
        if (arr == null) {
            return 1;
        }
        int sum = 0;
        // System.out.println(arr);
        for (int i = 0; i < arr.size(); i++) {
            sum = sum + Print(map, arr.get(i));
        }
        System.out.println("key:" + key + " chlid count : " + sum);
        return sum + 1;
    }
}
