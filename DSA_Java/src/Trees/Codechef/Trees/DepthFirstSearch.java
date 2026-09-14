package Trees.Codechef.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepthFirstSearch {
    static class Tree {
        private List<List<Integer>> adjList;

        public Tree(int n) {
            adjList = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
        }

        public void dfs(int node) {
            System.out.print(node + " ");
            for (int child : adjList.get(node)) {
                dfs(child);
            }
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Tree tree = new Tree(n);

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree.addEdge(u, v);
        }

        tree.dfs(1);

        scanner.close();
    }
}
