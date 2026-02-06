import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Aman91 {
    /*
     * For every contiguous subarray of size k, print the first negative number.
     * Ifnone, print 0
     */

    public static void main(String[] args) {
        int arr[] = new int[] { 100, 200, -1, 300, 400, -2, -1, 100 };
        int k = 2;
        Queue<Integer> q = new LinkedList<Integer>();

        int i = 0, j = 0;
        while (i < k) {
            if (arr[i] < 0) {
                q.add(arr[i]);
            }
            i++;
        }
        if (q.size() > 0) {
            System.out.println(q.peek());
        }
        while (i < arr.length) {
            if (arr[i] < 0) {
                q.add(arr[i]);
            }
            if (arr[j] < 0) {
                q.poll();
            }

            if (q.size() > 0) {
                // System.out.println("log:" + i + " " + j);
                System.out.println(q.peek());
            }
            j++;
            i++;
        }

    }
}
