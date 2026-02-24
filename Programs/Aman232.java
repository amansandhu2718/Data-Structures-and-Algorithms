import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Aman232 {

    // Itinerary is travel history from start to end
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("Chennai", "Banglore"));
        tickets.add(Arrays.asList("Bombay", "Delhi"));
        tickets.add(Arrays.asList("Goa", "Chennai"));
        tickets.add(Arrays.asList("Delhi", "Goa"));

        findItinerary(tickets);

    }

    public static void findItinerary(List<List<String>> tickets) {

        // finding starting point
        HashMap<String, Boolean> mp = new HashMap<>();
        HashMap<String, String> mp2 = new HashMap<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            mp2.put(src, dest);
            mp.put(dest, false);
            if (mp.containsKey(src)) {
                if (mp.get(src) == true) {
                    mp.put(src, false);
                }
            } else {
                mp.put(src, true);
            }
        }
        System.out.println(mp);

        String src = "";
        for (String key : mp.keySet()) {
            if (mp.get(key) == true) {
                src = key;
            }
        }
        System.out.println("src is : " + src);
        Find(src, mp2);

    }

    public static void Find(String src, HashMap<String, String> mp) {

        if (mp.containsKey(src)) {
            String val = mp.get(src);
            System.out.println(src);
            Find(val, mp);
        } else {
            System.out.println(src);
            return;
        }
    }
}
