import java.util.ArrayList;

public class Aman206 {
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 2, 10));

        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

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