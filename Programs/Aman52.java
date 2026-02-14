public class Aman52 {

    public static void main(String[] args) {

    }

    public static boolean checkValidGrid(int[][] grid) {

        int n = grid.length;

        // Must start from 0
        if (grid[0][0] != 0)
            return false;

        int x = 0, y = 0;

        // Knight moves
        int[][] moves = {
                { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 },
                { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }
        };

        for (int step = 1; step < n * n; step++) {

            boolean found = false;

            for (int[] m : moves) {

                int nx = x + m[0];
                int ny = y + m[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n
                        && grid[nx][ny] == step) {

                    x = nx;
                    y = ny;
                    found = true;
                    break;
                }
            }

            if (!found)
                return false;
        }

        return true;
    }
}
