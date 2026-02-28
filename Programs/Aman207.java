import java.util.ArrayList;

public class Aman207 {
    public static void main(String[] args) {
        int n = 7; // 7 friends are there (0 to 6)
        int arr[][] = new int[][] {
                { 0, 1 }, // 0 and 1 are same club
                { 2, 3 },
                { 4, 5 },
                { 5, 6 },
                { 4, 6 },
        };

        System.out.println("ok");
        // create graph from given data

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];

            graph[u].add(new Edge(u, v, 0));
            graph[v].add(new Edge(v, u, 0)); // IMPORTANT
        }
        GetConectedComponents(graph);
    }

    public static void GetConectedComponents(ArrayList<Edge>[] graph) {

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] Visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (Visited[i] == false) {
                ArrayList<Integer> arr = new ArrayList<>();
                DrawTree(i, graph, arr, Visited);
                comps.add(arr);
            }
        }

        System.out.println("comps: " + comps);
        int count = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                count = count + (comps.get(i).size() * comps.get(j).size());
            }
        }
        System.out.println(count);
    }

    public static void DrawTree(int src, ArrayList<Edge>[] graph, ArrayList<Integer> arr, boolean[] visited) {

        visited[src] = true;
        arr.add(src);
        for (int i = 0; i < graph[src].size(); i++) {
            if (visited[graph[src].get(i).nbr] == false) {
                DrawTree(graph[src].get(i).nbr, graph, arr, visited);
            }
        }
    }
}

class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
        this.src = src;
        this.wt = wt;
        this.nbr = nbr;
    }
}