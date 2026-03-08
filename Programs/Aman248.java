public class Aman248 {
    public static void main(String[] args) {
        int n = 100;
        Print(n);
    }

    public static void Print(int n) {

        for (int i = 1; i <= 9; i++) {
            DFS(n, i);
        }
    }

    public static void DFS(int n, int i) {
        if (i > n) {
            return;
        }

        System.out.println(i);
        for (int j = 0; j <= 9; j++) {
            DFS(n, i * 10 + j);
        }
    }
}
