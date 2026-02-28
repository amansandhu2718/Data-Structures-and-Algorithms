import java.util.ArrayDeque;
import java.util.ArrayList;

public class Aman212 {
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
        BFS(graph, 0, visited);
    }

    public static void BFS(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        q.add(new Pair(src, src + ""));
        while (q.size() > 0) {
            // r p a ---> r m* p a*

            Pair p = q.removeFirst();

            if (visited[p.vertex] == true) {
                continue;
            }
            visited[p.vertex] = true;

            System.out.println(p.vertex + " @ " + p.psf);

            for (int i = 0; i < graph[p.vertex].size(); i++) {
                q.add(new Pair(graph[p.vertex].get(i).nbr, p.psf + graph[p.vertex].get(i).nbr));
            }

        }
    }
}

class Pair {
    int vertex;
    String psf;

    Pair(int verext, String psf) {
        this.vertex = verext;
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