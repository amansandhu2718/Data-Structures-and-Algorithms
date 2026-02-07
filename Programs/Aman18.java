import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Aman18 {

    /**
     * Sudoku generator and solver
     * 
     * @param args
     */
    public static void main(String[] args) {

        // int[][] arr = {
        // {0,0,0, 0,0,0, 0,1,2},
        // {0,0,0, 0,0,0, 3,0,0},
        // {0,0,0, 0,0,0, 0,0,0},

        // {0,0,0, 0,0,0, 0,0,0},
        // {0,0,0, 0,0,0, 0,0,0},
        // {0,0,0, 0,0,0, 0,0,0},

        // {1,2,3, 0,0,0, 0,0,0},
        // {4,5,6, 0,0,0, 0,0,0},
        // {7,8,9, 0,0,0, 0,0,0}
        // };

        int[][] arr = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },

                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        // int[][] arr = {
        // {5, 3, 0, 0, 7, 0, 0, 0, 0},
        // {6, 0, 0, 1, 9, 5, 0, 0, 0},
        // {0, 9, 8, 0, 0, 0, 0, 6, 0},

        // {8, 0, 0, 0, 6, 0, 0, 0, 3},
        // {4, 0, 0, 8, 0, 3, 0, 0, 1},
        // {7, 0, 0, 0, 2, 0, 0, 0, 6},

        // {0, 6, 0, 0, 0, 0, 2, 8, 0},
        // {0, 0, 0, 4, 1, 9, 0, 0, 5},
        // {0, 0, 0, 0, 8, 0, 0, 7, 9}
        // };

        GenerateSudokuExactOneSolution(arr);
        // SolveSudoku(arr, 0, 0);
    }

    public static int count = 0;

    public static void PrintBoard(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean SolveSudoku(int arr[][], int row, int col) {

        // System.out.println("row is :" + row +" col is : "+ col);
        if (row == arr.length) {
            PrintBoard(arr);
            System.out.println();
            return true;
        }
        int nextI = 0;
        int nextJ = 0;
        if (col == arr[0].length - 1) {
            nextI = row + 1;
            nextJ = 0;
        } else {
            nextI = row;
            nextJ = col + 1;
        }
        if (arr[row][col] != 0) {
            return SolveSudoku(arr, nextI, nextJ);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (Isvalid(arr, row, col, i) == true) {
                    arr[row][col] = i;
                    boolean res = SolveSudoku(arr, nextI, nextJ);
                    if (res == true) {
                        return res;
                    }
                    arr[row][col] = 0;
                }
            }
        }
        return false;

    }

    public static boolean Isvalid(int arr[][], int row, int col, int val) {

        // check col
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == val) {
                return false;
            }
        }

        // check row
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == val) {
                return false;
            }
        }

        // check subarray
        int startI = 3 * (row / 3);
        int startJ = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[startI + i][startJ + j] == val) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void FillSubarrays(int arr[][]) {
        for (int i = 0; i < 9; i = i + 3) {
            fillSingleSbarray(arr, i, i);
        }
    }

    public static List<Integer> GetRandomNumbers() {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;

    }

    public static void fillSingleSbarray(int arr[][], int row, int col) {

        List<Integer> lst = GetRandomNumbers();

        int k = 0;
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[row + i][col + j] = lst.get(k);
                System.out.print(arr[row + i][col + j]);
                k++;
            }
            System.out.println();
        }

        System.out.println();
    }

    private static final Random rand = new Random();

    public static void GenerateSudokuExactOneSolution(int arr[][]) {
        FillSubarrays(arr);

        SolveSudoku(arr, 0, 0);

        int k = 10;

        while (k > 0) {
            int randI = rand.nextInt(9);
            int randJ = rand.nextInt(9);

            if (arr[randI][randJ] == 0) {
                continue;
            }

            int num = arr[randI][randJ];
            arr[randI][randJ] = 0;
            int[][] copy = copyGrid(arr);

            if (CheckIfHasOneSolution(copy)) {
                k--;
            } else {
                arr[randI][randJ] = num;
            }
        }
    }

    private static int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++)
            System.arraycopy(grid[i], 0, copy[i], 0, 9);
        return copy;
    }

    public static boolean CheckIfHasOneSolution(int arr[][]) {

        int solutions = SolutionCount(arr, 0, 0, 0);
        System.out.println(solutions);
        if (solutions == 1) {
            System.out.println("UNIQUE SOLUTION");
        } else if (solutions >= 2) {
            System.out.println("MULTIPLE SOLUTIONS");
        } else {
            System.out.println("NO SOLUTION");
        }

        return true;
    }

    public static int SolutionCount(int arr[][], int row, int col, int count) {

        // System.out.println("row is :" + row +" col is : "+ col);
        if (count > 1) {
            return count;
        }
        if (row == arr.length) {
            // PrintBoard(arr);
            // System.out.println();
            return count + 1;
        }
        int nextI = 0;
        int nextJ = 0;
        if (col == arr[0].length - 1) {
            nextI = row + 1;
            nextJ = 0;
        } else {
            nextI = row;
            nextJ = col + 1;
        }
        if (arr[row][col] != 0) {
            return SolutionCount(arr, nextI, nextJ, count);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (Isvalid(arr, row, col, i) == true) {
                    arr[row][col] = i;
                    int res = SolutionCount(arr, nextI, nextJ, count);
                    count = res;
                    if (res > 1) {
                        return res;
                    }
                    arr[row][col] = 0;
                }
            }
        }
        return count;

    }

}
