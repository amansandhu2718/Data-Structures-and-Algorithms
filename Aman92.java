import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Aman92 {
    /*
     * Find the maximum element in every window of size k.
     */

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 4, 3, 2, 1 };
        int k = 3;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int i = 1, j = 1;
        dq.add(0);

        while (i < k) {
            while (dq.size() > 0 && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            i++;
        }

        System.out.println(arr[dq.peekFirst()]);

        while (i < arr.length) {

            // remove logic
            if (dq.peekFirst() < j) {
                dq.pollFirst();
            }

            // add logic
            while (dq.size() > 0 && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);

            System.out.println(arr[dq.peekFirst()]);

            j++;
            i++;
        }

    }
}
