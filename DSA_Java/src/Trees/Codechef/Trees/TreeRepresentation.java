package Trees.Codechef.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TreeRepresentation {

    // =========================================================
    // Normal Tree
    // =========================================================

    public static class Tree {

        public static int n;

        // Adjacency Matrix
        private final int[][] adjMatrix;

        // Adjacency List
        private static ArrayList<ArrayList<Integer>> adjList ;

        public static ArrayList<ArrayList<Integer>> getAdjList() {
            return adjList;
        }

        public static int getNode(){
            return n;
        }


        // ---------------------------------------------------------
        // Constructor
        // ---------------------------------------------------------

        public Tree(int n) {

            this.n = n;

            // Nodes are numbered from 1 to n
            this.adjMatrix = new int[n + 1][n + 1];

            this.adjList = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
        }


        // ---------------------------------------------------------
        // Add Edge
        // ---------------------------------------------------------

        // Directed edge: a → b
        public void addEdge(int a, int b) {

            // Adjacency Matrix
            adjMatrix[a][b] = 1;

            // Adjacency List
            adjList.get(a).add(b);
        }


        // ---------------------------------------------------------
        // Print Adjacency Matrix
        // ---------------------------------------------------------

        public void printAdjMatrix() {

            System.out.println("Adjacency Matrix:");

            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= n; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }

                System.out.println();
            }
        }


        // ---------------------------------------------------------
        // Print Adjacency List
        // ---------------------------------------------------------

        public void printAdjList() {

            System.out.println("\nAdjacency List:");

            for (int i = 1; i <= n; i++) {

                System.out.print(i + " → ");

                for (int child : adjList.get(i)) {
                    System.out.print(child + " ");
                }

                System.out.println();
            }
        }


        // ---------------------------------------------------------
        // DFS
        // ---------------------------------------------------------

        public void dfs(int node) {

            System.out.print(node + " ");

            for (int i = 0; i < adjList.get(node).size(); i++) {

                int child = adjList.get(node).get(i);

                dfs(child);
            }
        }


        // ---------------------------------------------------------
        // BFS
        // ---------------------------------------------------------

        public void bfs(int root) {

            Queue<Integer> queue = new LinkedList<>();

            boolean[] visited = new boolean[n + 1];

            // Add root
            queue.add(root);
            visited[root] = true;

            while (!queue.isEmpty()) {

                // Remove front node
                int node = queue.poll();

                System.out.print(node + " ");

                // Visit children
                for (int child : adjList.get(node)) {

                    if (!visited[child]) {

                        visited[child] = true;
                        queue.add(child);
                    }
                }
            }
        }
    }


    // =========================================================
    // Weighted Tree
    // =========================================================

    public static class WeightedTree {

        private final int n;

        // ---------------------------------------------------------
        // Edge
        // ---------------------------------------------------------

        public static class Edge {

            public int node;
            public int weight;

            public Edge(int node, int weight) {

                this.node = node;
                this.weight = weight;
            }
        }


        // ---------------------------------------------------------
        // Data Structures
        // ---------------------------------------------------------

        // Weighted Adjacency Matrix
        private final int[][] adjMatrix;

        // Weighted Adjacency List
        private final ArrayList<ArrayList<Edge>> adjList;


        // ---------------------------------------------------------
        // Constructor
        // ---------------------------------------------------------

        public WeightedTree(int n) {

            this.n = n;

            // Nodes are numbered from 1 to n
            this.adjMatrix = new int[n + 1][n + 1];

            this.adjList = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
        }


        // ---------------------------------------------------------
        // Add Weighted Edge
        // ---------------------------------------------------------

        // Directed weighted edge: a → b
        public void addEdge(int a, int b, int weight) {

            // Adjacency Matrix
            adjMatrix[a][b] = weight;

            // Adjacency List
            adjList.get(a).add(new Edge(b, weight));
        }


        // ---------------------------------------------------------
        // Print Weighted Adjacency Matrix
        // ---------------------------------------------------------

        public void printAdjMatrix() {

            System.out.println("Weighted Adjacency Matrix:");

            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= n; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }

                System.out.println();
            }
        }


        // ---------------------------------------------------------
        // Print Weighted Adjacency List
        // ---------------------------------------------------------

        public void printAdjList() {

            System.out.println("\nWeighted Adjacency List:");

            for (int i = 1; i <= n; i++) {

                System.out.print(i + " → ");

                for (Edge edge : adjList.get(i)) {

                    System.out.print(
                            "(" + edge.node + ", " + edge.weight + ") "
                    );
                }

                System.out.println();
            }
        }
    }


    // =========================================================
    // Main
    // =========================================================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Tree tree = new Tree(n);

        // A tree with n nodes has n - 1 edges
        for (int i = 0; i < n - 1; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            tree.addEdge(u, v);
        }

        System.out.println("DFS:");
        tree.dfs(1);

        System.out.println("\n\nBFS:");
        tree.bfs(1);

        sc.close();
    }
}