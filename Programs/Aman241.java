import java.util.ArrayDeque;
import java.util.ArrayList;

public class Aman241 {
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // graph[0].add(new Edge(0, 1, 10));

        // graph[1].add(new Edge(1, 0, 10));

        // graph[2].add(new Edge(2, 3, 10));
        // graph[3].add(new Edge(3, 2, 10));

        // graph[4].add(new Edge(4, 5, 3));
        // graph[4].add(new Edge(4, 6, 3));

        // graph[5].add(new Edge(5, 4, 3));
        // graph[5].add(new Edge(5, 6, 3));

        // graph[6].add(new Edge(6, 5, 3));
        // graph[6].add(new Edge(6, 4, 8));

        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));

        System.out.println(IsGraphBiPartite(graph));
    }

    public static boolean IsGraphBiPartite(ArrayList<Edge>[] graph) {

        int visited[] = new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) { // check only if vertex is not visited
                boolean cB = IsComponentBipartite(graph, visited, i);
                if (!cB) {
                    return false; // if any component is not bipartite then graph is not bipartite
                }
            }
        }
        return true;
    }

    public static boolean IsComponentBipartite(ArrayList<Edge>[] graph, int visited[], int src) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0, src + ""));
        while (q.size() > 0) {
            // r m* w a*
            Pair rem = q.removeFirst(); // remove
            if (visited[rem.vertex] != -1) { // mark
                if (visited[rem.vertex] != rem.level) {
                    return false;
                }
            } else {
                visited[rem.vertex] = rem.level;
            }

            for (Edge e : graph[rem.vertex]) {
                if (visited[e.nbr] == -1) {
                    q.add(new Pair(e.nbr, rem.level + 1, rem.psf + e.nbr));
                }
            }
        }
        return true;
    }
}

class Pair {
    int vertex;
    int level;
    String psf;

    Pair(int V, int L, String psf) {
        this.vertex = V;
        this.level = L;
        this.psf = psf;
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