import java.util.HashSet;
import java.util.PriorityQueue;

public class Aman74 {
    public static void main(String[] args) {

        int arr[] = new int[] { 1, 2, 9, 6, 3, 4, 5, 8, 7, 8, 9 };
        System.out.println(FindKthLargestElement(arr, 3));
    }

    public static int FindKthLargestElement(int arr[], int k) {
        if (arr.length == 0) {
            throw new Error("Sizeee is 0 !!!");
        }
        if (arr.length == 1) {
            return arr[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hs.contains(arr[i])) {
                hs.add(arr[i]);
                pq.add(arr[i]);
                System.out.println("added : " + arr[i]);

                while (pq.size() > k) {
                    System.out.println("removed a : " + pq.poll());

                }
            }
        }
        return pq.peek();
    }
}
