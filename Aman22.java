public class Aman22 {
    public static void main(String[] args) {

        // int arr[] = new int[]{1, 2, 1, 1, 1};
        int arr[] = new int[]{2, 3, 1, 1, 4};

        int m = 0;
        int count = 0;

        while (m < arr.length) {

            System.out.println("val: " + arr[m]);

            // reached end already
            if (m >= arr.length - 1) {
                System.out.println("Reached end");
                break;
            }

            // if stuck
            if (arr[m] == 0) {
                System.out.println("cannot go further..!!");
                break;
            }

            int l = m + 1;
            int r = m + arr[m];

            System.out.println("range : " + l + " - " + r);

            if (r >= arr.length - 1) {
                // final jump to end
                count++;
                System.out.println("Reached end");
                break;
            }

            // find the best jump (max reach)
            int maxReach = l + arr[l];
            int indexOfMax = l;

            for (int i = l; i <= r; i++) {
                if (i + arr[i] > maxReach) {
                    maxReach = i + arr[i];
                    indexOfMax = i;
                }
            }

            // do the jump
            m = indexOfMax;
            count++;

            System.out.println("Jumping to index: " + m);
        }

        System.out.println("Total jumps: " + count);
    }
}
