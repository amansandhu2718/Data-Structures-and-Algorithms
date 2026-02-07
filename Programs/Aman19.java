public class Aman19 {
    public static void main(String[] args) {

        int n = 4;
        int arr[][] = new int[n][n];

        NQueens(arr, "", 0);

    }

    public static void NQueens(int arr[][], String qsf, int row) {
        if (row == arr.length) {
            System.out.println(qsf);
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            if (CanPlace(arr, row, col) == true) {
                arr[row][col] = 1;
                NQueens(arr, qsf + " " + row + " - " + col + " \t  ", row + 1);
                arr[row][col] = 0;
            }
        }
    }

    public static boolean CanPlace(int arr[][], int row, int col) {

        // straight
        for (int i = row - 1; i >= 0; i--) {
            if (arr[i][col] == 1) {
                return false;
            }
        }

        // diagonal left

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

            if (arr[i][j] == 1) {
                return false;
            }

        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < arr[0].length; i--, j++) {
            if (arr[i][j] == 1) {
                return false;
            }

        }

        return true;
    }

}
