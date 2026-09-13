package Trees.Codechef.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImplementationAdjacencyList {

    static class Tree {
        private int n;
        private List<List<Integer>> adjList;

        public Tree(int n) {
            this.n = n;
            this.adjList = new ArrayList<>();

            // Create n empty adjacency lists
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int a, int b) {
            adjList.get(a).add(b);
        }

        public void printAdjList() {
            System.out.println("\nAdjacency List:");

            for (int i = 0; i < n; i++) {
                System.out.print(i + " → ");

                for (int j = 0; j < adjList.get(i).size(); j++) {
                    System.out.print(adjList.get(i).get(j) + " ");
                }

                System.out.println();
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            Tree tree = new Tree(n);

            // A tree with n vertices has n - 1 edges
            for (int i = 0; i < n - 1; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                tree.addEdge(a, b);
            }

            tree.printAdjList();

            sc.close();
        }
    }
}