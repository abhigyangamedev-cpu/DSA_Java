package Trees.Codechef.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static Trees.Codechef.Trees.TreeRepresentation.Tree.n;


public class BreadthFirstSearch {
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
            for (int child : TreeRepresentation.Tree.getAdjList().get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TreeRepresentation.Tree tree = new TreeRepresentation.Tree(n);

        // A tree with n nodes has n - 1 edges
        for (int i = 0; i < n - 1; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            tree.addEdge(u, v);
        }

        tree.bfs(1);
    }
}
