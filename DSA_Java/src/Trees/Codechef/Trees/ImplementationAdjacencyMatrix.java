package Trees.Codechef.Trees;
import java.util.Scanner;

public class ImplementationAdjacencyMatrix {

    static class Tree {
        private int n;
        private int[][] adjMatrix;

        public Tree(int n){
            this.n = n;
            this.adjMatrix = new int[n][n];
        }

        public void addEdge(int a, int b){
            adjMatrix[a][b] = 1;
        }

        public void printAdjMatrix(){
            for(int i =0; i < n; i++){
                for(int j =0; j <n; j++){
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Tree tree = new Tree(n);

        for(int i =0; i <n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree.addEdge(a,b);
        }

        tree.printAdjMatrix();

        sc.close();

    }
}
