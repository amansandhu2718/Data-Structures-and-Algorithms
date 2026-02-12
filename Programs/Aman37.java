public class Aman37 {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int res[] = ContainerWithMostWater(arr);

        System.out.println("i: " + res[0]);
        System.out.println("j: " + res[1]);
        System.out.println("amount: " + res[2]);
    }

    public static int[] ContainerWithMostWater(int arr[]) {
        if (arr.length == 0 || arr.length == 1) {
            return new int[] { -1, -1, -1 };
        }

        int res[] = new int[3];

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int width = high - low;
            int height = arr[low];

            if (arr[high] < arr[low]) {
                height = arr[high];
            }
            int area = width * height;
            if (area > res[2]) {
                res[2] = area;
                res[0] = low;
                res[1] = high;
            }

            if (arr[low] <= arr[high]) {
                low++;
            } else {
                high--;
            }
        }

        return res;
    }
}
