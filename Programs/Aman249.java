import java.util.ArrayList;

public class Aman249 {
    public static void main(String[] args) {

        int arr[][] = new int[][] {
                { 10, 0, 100, 200, 0, 8, 0 },
                { 20, 0, 0, 0, 0, 6, 0 },
                { 30, 0, 0, 9, 12, 3, 4 },
                { 40, 0, 2, 5, 8, 3, 11 },
                { 0, 0, 0, 0, 0, 9, 0 },
                { 5, 6, 7, 0, 7, 4, 2 },
                { 8, 9, 10, 0, 1, 10, 8 }
        };
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    ArrayList<Integer> bag = new ArrayList<>();
                    MaxGold(arr, i, j, bag);
                    int sum = 0;
                    for (int k = 0; k < bag.size(); k++) {
                        sum = sum + bag.get(k);
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum);
    }

    public static void MaxGold(int arr[][], int row, int col, ArrayList<Integer> bag) {

        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == 0) {
            return;
        }
        bag.add(arr[row][col]);
        arr[row][col] = 0;
        MaxGold(arr, row - 1, col, bag);
        MaxGold(arr, row + 1, col, bag);
        MaxGold(arr, row, col - 1, bag);
        MaxGold(arr, row, col + 1, bag);
    }
}
