public class Aman245 {
    public static void main(String[] args) {
        int n = 4;
        int arr[][] = new int[n][n];
        BranchAndBound(arr, 0, new boolean[n], new boolean[(2 * n) - 1], new boolean[(2 * n) - 1], "");
    }

    public static void BranchAndBound(int arr[][], int row, boolean cols[], boolean d1[], boolean d2[], String psf) {
        if (row == arr.length) {
            System.out.println(psf);
            return;
        }
        for (int col = 0; col < arr[0].length; col++) {
            if (cols[col] == false && d1[row + col] == false && d2[row - col + (arr[0].length - 1)] == false) {

                cols[col] = true;
                d1[col + row] = true;
                d2[row - col + (arr[0].length - 1)] = true;
                arr[row][col] = 1;
                BranchAndBound(arr, row + 1, cols, d1, d2, psf + " [" + row + "-" + col + "] ");
                cols[col] = false;
                d1[col + row] = false;
                d2[row - col + (arr[0].length - 1)] = false;
                arr[row][col] = 0;
            }
        }
    }
}

// total Normal (left) diagonls= 2*n-1
// normal diagonal = r + c

// total reverse (right) diagonals = 2*n-1
// reverse diagonal = r-c + (board.length-1)
// https://www.youtube.com/watch?v=yvt0emtFiIE&list=PL-Jc9J83PIiE-181crLG1xSIWhTGKFiMY&index=2