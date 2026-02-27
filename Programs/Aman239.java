import java.util.ArrayList;
import java.util.PriorityQueue;

public class Aman239 {
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

        PrintAllPathsWRTWeights(graph, 0, 6, visited, "0", 0);
        System.out.println("3rd Longest Path  is wrt Weight  : " + hp.peek().psf + " wt: " + hp.peek().wsf);
    }

    public static String LongestPath = null;
    public static int LargestWeight = Integer.MIN_VALUE;
    public static PriorityQueue<Pair> hp = new PriorityQueue<>();

    public static void PrintAllPathsWRTWeights(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,
            String psf, int wsf) {
        if (src == dest) {
            System.out.println(psf + " wt: " + wsf);

            if (hp.size() < 3) {
                hp.add(new Pair(wsf, psf));
            } else {
                if (wsf > hp.peek().wsf) {
                    hp.poll();
                    hp.add(new Pair(wsf, psf));
                }
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

class Pair implements Comparable<Pair> {
    int wsf;
    String psf;

    Pair(int wsf, String psf) {
        this.wsf = wsf;
        this.psf = psf;
    }

    @Override
    public int compareTo(Pair o) {
        return this.wsf - o.wsf;
    }
}