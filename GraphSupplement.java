import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphSupplement {
    // static class Edge {
    // int src;
    // int dest;
    // int wt;

    // public Edge(int s, int d, int w) {
    // this.src = s;
    // this.dest = d;
    // this.wt = w;
    // }
    // }

    // public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
    // for (int i = 0; i < graph.length; i++) {
    // graph[i] = new ArrayList<>();
    // }

    // for (int i = 0; i < flights.length; i++) {
    // int src = flights[i][0];
    // int dest = flights[i][1];
    // int wt = flights[i][2];

    // Edge e = new Edge(src, dest, wt);
    // graph[src].add(e);
    // }
    // }

    // static class Info {
    // int v;
    // int cost;
    // int stop;

    // public Info(int v, int c, int s) {
    // this.v = v;
    // this.cost = c;
    // this.stop = s;
    // }
    // }

    // public static int cheapestFlights(int n, int flights[][], int src, int dest,
    // int k) {
    // ArrayList<Edge> graph[] = new ArrayList[n];
    // createGraph(flights, graph);
    // int dist[] = new int[n];

    // for (int i = 0; i < dist.length; i++) {
    // if (i != src) {
    // dist[i] = Integer.MAX_VALUE;
    // }
    // }

    // Queue<Info> q = new LinkedList<>();
    // q.add(new Info(src, 0, 0));

    // while (!q.isEmpty()) {
    // Info curr = q.remove();

    // if (curr.stop > k) {
    // break;
    // }
    // for (int i = 0; i < graph[curr.v].size(); i++) {
    // Edge e = graph[curr.v].get(i);
    // int u = e.src;
    // int v = e.dest;
    // int wt = e.wt;

    // if (curr.cost + wt < dist[v] && curr.stop <= k) {
    // dist[v] = curr.cost + wt;
    // q.add(new Info(v, dist[v], curr.stop + 1));
    // }
    // }
    // }

    // if (dist[dest] == Integer.MAX_VALUE) {
    // return -1;
    // } else {
    // return dist[dest];
    // }
    // }

    // static class Edge implements Comparable<Edge> {
    // int dest;
    // int cost;

    // public Edge(int d, int c) {
    // this.dest = d;
    // this.cost = c;
    // }

    // @Override
    // public int compareTo(Edge e2) {
    // return this.cost - e2.cost;
    // }

    // }

    // public static int minimumCost(int cities[][]) {
    // boolean vis[] = new boolean[cities.length];
    // PriorityQueue<Edge> pq = new PriorityQueue<>();

    // pq.add(new Edge(0, 0));
    // int finalCost = 0;

    // while (!pq.isEmpty()) {
    // Edge curr = pq.remove();
    // if (!vis[curr.dest]) {
    // vis[curr.dest] = true;
    // finalCost += curr.cost;
    // for (int i = 0; i < cities[curr.dest].length; i++) {
    // if (cities[curr.dest][i] != 0) {
    // pq.add(new Edge(i, cities[curr.dest][i]));
    // }
    // }
    // }
    // }

    // return finalCost;
    // }

    // public static void helper(int images[][], int sr, int sc, int col, boolean
    // vis[][], int orgCol) {
    // if (sr < 0 || sc < 0 || sr >= images.length || sc >= images[0].length ||
    // vis[sr][sc]
    // || images[sr][sc] != orgCol) {
    // return;
    // }
    // helper(images, sr, sc - 1, col, vis, orgCol);
    // helper(images, sr, sc + 1, col, vis, orgCol);
    // helper(images, sr - 1, sc, col, vis, orgCol);
    // helper(images, sr, sc + 1, col, vis, orgCol);
    // }

    // public static int[][] fooldFillAlgorithm(int images[][], int sr, int sc, int
    // col) {
    // boolean vis[][] = new boolean[images.length][images[0].length];
    // helper(images, sr, sc, col, vis, images[sr][sc]);
    // return images;
    // }

    // static class Edge implements Comparable<Edge> {
    // int src;
    // int dest;
    // int wt;

    // public Edge(int s, int d, int w) {
    // this.src = s;
    // this.dest = d;
    // this.wt = w;
    // }

    // @Override
    // public int compareTo(Edge e2) {
    // return this.wt - e2.wt;
    // }
    // }

    // static int n = 4;
    // static int par[] = new int[n];
    // static int rank[] = new int[n];

    // public static void init() {
    // for (int i = 0; i < n; i++) {
    // par[i] = i;
    // }
    // }

    // public static int find(int x) {
    // if (x == par[x]) {
    // return x;
    // }
    // return par[x] = find(par[x]);
    // }

    // public static void union(int a, int b) {
    // int parA = find(a);
    // int parB = find(b);

    // if (rank[parA] == rank[parB]) {
    // par[parB] = parA;
    // rank[parA]++;
    // } else if (rank[parB] > rank[parA]) {
    // par[parA] = parB;
    // } else {
    // par[parB] = parA;
    // }
    // }

    // public static void createGraph(ArrayList<Edge> edges) {
    // edges.add(new Edge(0, 1, 10));
    // edges.add(new Edge(0, 2, 15));
    // edges.add(new Edge(0, 3, 30));
    // edges.add(new Edge(1, 3, 40));
    // edges.add(new Edge(2, 3, 50));
    // }

    // public static void kruskalsMST(ArrayList<Edge> edges, int V) {
    // Collections.sort(edges);
    // int mstCost = 0;
    // int count = 0;

    // init();

    // for (int i = 0; count < V - 1; i++) {
    // Edge e = edges.get(i);

    // int parA = find(e.src);
    // int parB = find(e.dest);
    // if (parA != parB) {
    // union(e.src, e.dest);
    // mstCost += e.wt;
    // count++;
    // }
    // }
    // System.out.println("MST COUNT =" + mstCost);
    // }

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    // public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[],
    // Stack<Integer> s) {
    // vis[curr] = true;

    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // if (!vis[e.dest]) {
    // topSort(graph, e.dest, vis, s);
    // }
    // }
    // s.push(curr);
    // }

    // public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
    // vis[curr] = true;
    // System.out.print(curr + " ");

    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // if (!vis[e.dest]) {
    // dfs(graph, e.dest, vis);
    // }
    // }
    // }

    // public static void Kasaraju(ArrayList<Edge> graph[], int V) {
    // Stack<Integer> s = new Stack<>();
    // boolean vis[] = new boolean[V];

    // for (int i = 0; i < V; i++) {
    // if (!vis[i]) {
    // topSort(graph, i, vis, s);
    // }
    // }

    // ArrayList<Edge> transpose[] = new ArrayList[V];

    // for (int i = 0; i < V; i++) {
    // vis[i] = false;
    // transpose[i] = new ArrayList<Edge>();
    // }

    // for (int i = 0; i < V; i++) {
    // for (int j = 0; j < graph[i].size(); j++) {
    // Edge e = graph[i].get(j);
    // transpose[e.dest].add(new Edge(e.dest, e.src));
    // }
    // }

    // while (!s.isEmpty()) {
    // int curr = s.pop();
    // if (!vis[curr]) {
    // System.out.print("SCC --->");
    // dfs(transpose, curr, vis);
    // System.out.println();
    // }
    // }
    // }

    // public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[],
    // int low[], boolean vis[], int time) {
    // vis[curr] = true;
    // dt[curr] = low[curr] = ++time;

    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // int neigh = e.dest;
    // if (neigh == par) {
    // continue;
    // } else if (!vis[neigh]) {
    // dfs(graph, neigh, curr, dt, low, vis, time);
    // low[curr] = Math.min(low[curr], low[neigh]);
    // if (dt[curr] < low[neigh]) {
    // System.out.println("Bridge : " + curr + "----" + neigh);
    // }
    // } else {
    // low[curr] = Math.min(low[curr], dt[neigh]);
    // }
    // }
    // }

    // public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
    // int dt[] = new int[V];
    // int low[] = new int[V];
    // int time = 0;
    // boolean vis[] = new boolean[V];
    // for (int i = 0; i < V; i++) {
    // if (!vis[i]) {
    // dfs(graph, i, -1, dt, low, vis, time);
    // }
    // }
    // }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time,
            boolean ap[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == par) {
                continue;
            } else if (vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfs(graph, neigh, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }

        }
        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                System.out.println("AP" + i);
            }
        }
    }

    public static void main(String[] args) {
        // int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600
        // }, { 2, 3, 200 } };
        // int src = 0;
        // int dest = 3;
        // int k = 1;

        // System.out.println(cheapestFlights(5, flights, src, dest, k));

        // int cities[][] = { { 0, 1, 2, 3, 4 }, { 1, 0, 5, 0, 7 }, { 2, 5, 0, 6, 0 }, {
        // 3, 0, 6, 0, 0 },
        // { 4, 7, 0, 0, 0 } };

        // System.out.println(minimumCost(cities));

        // init();
        // System.out.println(find(3));
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);

        // int images[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        // fooldFillAlgorithm(images, 0, 0, 2)

        // ArrayList<Edge> edges = new ArrayList<>();
        // createGraph(edges);
        // kruskalsMST(edges, n);

        // int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // Kasaraju(graph, V);

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // tarjanBridge(graph, V);
        getAP(graph, V);
    }
}
