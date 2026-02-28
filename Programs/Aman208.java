import java.util.ArrayList;
import java.util.HashSet;

public class Aman208 {
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
        graph[2].add(new Edge(2, 5, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));
        graph[5].add(new Edge(5, 2, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        // boolean[] visited = new boolean[graph.length];
        HashSet<Integer> visited = new HashSet<>();
        PrintAllPaths(graph, 0, visited, "0", 0);
    }

    public static void PrintAllPaths(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int oSrc) {

        if (visited.size() == graph.length - 1) { // this is nth person
            boolean has = false;
            for (int i = 0; i < graph[src].size(); i++) {
                if (graph[src].get(i).nbr == oSrc) {
                    has = true;
                    break;
                }
            }

            if (has) {
                System.out.println("Hamiltonion cycle: " + psf);
            } else {
                System.out.println("Hamiltonion path: " + psf);
            }
            return;

        }
        visited.add(src);
        for (int i = 0; i < graph[src].size(); i++) {
            if (visited.contains(graph[src].get(i).nbr) == false) {
                PrintAllPaths(graph, graph[src].get(i).nbr, visited, psf + graph[src].get(i).nbr, oSrc);
            }
        }
        visited.remove(src);
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