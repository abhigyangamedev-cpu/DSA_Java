package Trees.Codechef.Trees;

import java.util.ArrayList;

public class TreeRepresentation {
    // Normal Tree
    public static class Tree {

        public int n;
        public int[][] adjMatrix;
        public ArrayList<ArrayList<Integer>> adjList;

        public Tree(int n) {
            this.n = n;

            // Adjacency Matrix
            this.adjMatrix = new int[n][n];

            // Adjacency List
            this.adjList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Add a directed edge: a → b
        public void addEdge(int a, int b) {
            adjMatrix[a][b] = 1;
            adjList.get(a).add(b);
        }

        // Print Adjacency Matrix
        public void printAdjMatrix() {

            System.out.println("Adjacency Matrix:");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Print Adjacency List
        public void printAdjList() {

            System.out.println("\nAdjacency List:");

            for (int i = 0; i < n; i++) {

                System.out.print(i + " → ");

                for (int node : adjList.get(i)) {
                    System.out.print(node + " ");
                }

                System.out.println();
            }
        }
    }


    // Weighted Tree
    public static class WeightedTree {

        // Represents one weighted edge
        public static class Edge {

            public int node;
            public int weight;

            public Edge(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }
        }

        public int n;

        // Weighted Adjacency Matrix
        public int[][] adjMatrix;

        // Weighted Adjacency List
        public ArrayList<ArrayList<Edge>> adjList;


        public WeightedTree(int n) {
            this.n = n;

            // Weighted Adjacency Matrix
            this.adjMatrix = new int[n][n];

            // Weighted Adjacency List
            this.adjList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
        }


        // Add a directed weighted edge: a → b
        public void addEdge(int a, int b, int weight) {

            // Adjacency Matrix
            adjMatrix[a][b] = weight;

            // Adjacency List
            adjList.get(a).add(new Edge(b, weight));
        }


        // Print Weighted Adjacency Matrix
        public void printAdjMatrix() {

            System.out.println("Weighted Adjacency Matrix:");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }


        // Print Weighted Adjacency List
        public void printAdjList() {

            System.out.println("\nWeighted Adjacency List:");

            for (int i = 0; i < n; i++) {

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





    public static void main(String[] args) {

        // Create a tree with 5 nodes Normal Tree
        Tree tree = new Tree(5);

        // Add directed edges Normal Tree
        tree.addEdge(0, 1);
        tree.addEdge(0, 2);
        tree.addEdge(1, 3);
        tree.addEdge(1, 4);

        // Print adjacency matrix Normal Tree
        System.out.println("Printing Adjacency Matrix for normal Tree");
        tree.printAdjMatrix();

        // Print adjacency list Normal Tree
        System.out.println("Printing Adjacency list for normal Tree");
        tree.printAdjList();

        // Create a tree with 5 nodes Weighted Tree
        WeightedTree weightedTree = new WeightedTree(5);

        // Add directed edges Weighted Tree
        weightedTree.addEdge(0,1,2);
        weightedTree.addEdge(0,2,3);
        weightedTree.addEdge(1,3,2);
        weightedTree.addEdge(1,4,4);

        // Print adjacency matrix Weighted Tree
        System.out.println("Printing Adjacency Matrix for Weighted Tree");
        weightedTree.printAdjMatrix();

        // Print adjacency list Weighted Tree
        System.out.println("Printing Adjacency list for Weighted Tree");
        weightedTree.printAdjList();


    }

}
