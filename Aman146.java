
public class Aman146 {
    public static void main(String[] args) {

        // char arr[][] = new char[][] {
        // { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        // { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        // { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        // { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        // { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        // { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        // { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        // { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        // { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
        // };

        char arr[][] = new char[][] {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(arr));
    }

    public static boolean isValidSudoku(char[][] board) {

        return SolveSudoku(board, 0, 0);
    }

    public static char charsArr[] = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public static boolean SolveSudoku(char[][] arr, int i, int j) {
        if (i == arr.length) {
            return true;
        }
        int nextI = 0;
        int nextJ = 0;
        if (j == arr[0].length - 1) {
            nextI = i + 1;
            nextJ = 0;
        } else {
            nextI = i;
            nextJ = j + 1;
        }

        if (arr[i][j] != '.') {
            return SolveSudoku(arr, nextI, nextJ);
        }
        for (int x = 0; x < charsArr.length; x++) {
            char candidate = charsArr[x];
            if (isvalid(arr, candidate, i, j)) {
                arr[i][j] = candidate;
                boolean res = SolveSudoku(arr, nextI, nextJ);
                if (res == false) {
                    arr[i][j] = '.';
                } else {
                    return res;
                }
            }
        }
        return false;

    }

    public static boolean isvalid(char board[][], char num, int row, int col) {

        // row
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // subarray
        int topLeftIndexRow = (row / 3) * 3;
        int topLeftIndexCol = (col / 3) * 3;
        for (int i = topLeftIndexRow; i < topLeftIndexRow + 3; i++) {
            for (int j = topLeftIndexCol; j < topLeftIndexCol + 3; j++) {

                if (board[i][j] == num) {
                    return false;
                }

            }

        }
        return true;
    }
}
