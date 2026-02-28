import java.util.ArrayList;

public class Aman206 {
    public static void main(String[] args) {

        int arr[][] = new int[][] {

                { 0, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0 },
        };
        System.out.println("total: " + GetNumberOfislands(arr));
    }

    public static int GetNumberOfislands(int arr[][]) {
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        ArrayList<ArrayList<String>> comps = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 && visited[i][j] == false) {
                    ArrayList<String> comp = new ArrayList<>();
                    DrawTree(arr, visited, i, j, comp);
                    comps.add(comp);
                }
            }
        }
        System.out.println(comps);
        return comps.size();
    }

    public static void DrawTree(int arr[][], boolean visited[][], int i, int j, ArrayList<String> comp) {

        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
            return;
        }
        // water check (IMPORTANT)
        if (arr[i][j] == 1) {
            return;
        }
        if (visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        String val = " i: " + i + " j " + j + " ";
        comp.add(val);

        int nextI = i - 1;
        int nextJ = j;
        DrawTree(arr, visited, nextI, nextJ, comp); // top
        nextI = i;
        nextJ = j - 1;
        DrawTree(arr, visited, nextI, nextJ, comp);// left
        nextI = i + 1;
        nextJ = j;
        DrawTree(arr, visited, nextI, nextJ, comp);// bottom
        nextI = i;
        nextJ = j + 1;
        DrawTree(arr, visited, nextI, nextJ, comp);// right

    }

}