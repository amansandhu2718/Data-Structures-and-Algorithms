import java.util.ArrayList;

public class Aman235 {
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        boolean[] visited = new boolean[graph.length];

        PrintAllPaths(graph, 0, 6, visited, "0");
        System.out.println("Longest Path  is  : " + LongestPath);

        PrintAllPathsWRTWeights(graph, 0, 6, visited, "0", 0);
        System.out.println("Longest Path  is wrt Weight  : " + LongestPath);
    }

    public static String LongestPath = null;
    public static int LargestWeight = Integer.MIN_VALUE;

    public static void PrintAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            if (LongestPath == null || psf.length() < LongestPath.length()) {
                LongestPath = psf;
            }
            return;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            if (visited[graph[src].get(i).nbr] == false) {
                PrintAllPaths(graph, graph[src].get(i).nbr, dest, visited, psf + " " + graph[src].get(i).nbr);
            }
        }
        visited[src] = false;
    }

    public static void PrintAllPathsWRTWeights(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,
            String psf, int wsf) {
        if (src == dest) {
            System.out.println(psf);
            if (wsf > LargestWeight) {
                LargestWeight = wsf;
                LongestPath = psf;
            }
            return;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            if (visited[graph[src].get(i).nbr] == false) {
                PrintAllPathsWRTWeights(graph, graph[src].get(i).nbr, dest, visited, psf + " " + graph[src].get(i).nbr,
                        wsf + graph[src].get(i).wt);
            }
        }
        visited[src] = false;
    }
}

// source , neighbour , weight
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