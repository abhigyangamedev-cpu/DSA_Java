package Trees.Codechef.Trees;

import java.util.Scanner;

public class CountNumberOfLeafNodes {
    static int leaves = 0;

    public static void dfs(int vertex, int[][] adjMatrix) {
        boolean childPresent = false;
        // Traversing through children of vertex through this for loop
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[vertex][i] == 1) {
                childPresent = true;
                dfs(i, adjMatrix);
            }
        }
        // Using the logic that a leaf node does not have any children
        if (!childPresent) {
            leaves++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] adjMatrix = new int[N][N];

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjMatrix[a][b] = 1;
        }

        dfs(0, adjMatrix);
        System.out.println(leaves);
    }
}
