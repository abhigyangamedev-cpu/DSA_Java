package Trees.Codechef.Trees;

public class BinaryTrees {
    static class BinaryTree{
        int val;
        static BinaryTree root;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(){}

        BinaryTree(int val){
            this.val = val;
        }


        public static void preOrderTraversal(BinaryTree root){
            if(root == null) return;

            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public static void inOrderTraversal(BinaryTree root){
            if(root == null) return;

            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }

        public static void postOrderTraversal(BinaryTree root){
            if(root == null) return;

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }

        public static int depth(BinaryTree root){
            if(root == null) return 0;

            int left = depth(root.left);
            int right = depth(root.right);

            return 1 + Math.max(left,right);
        }

        public static int height(BinaryTree root){
            return Math.max(0,depth(root) - 1);
        }


    }

    public static void main(String[] args){


        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        BinaryTree.root = node1;

        System.out.println("Preorder Traversal");
        BinaryTree.preOrderTraversal(BinaryTree.root);
        System.out.println();

        System.out.println("Inorder Traversal");
        BinaryTree.inOrderTraversal(BinaryTree.root);
        System.out.println();

        System.out.println("Postorder Traversal");
        BinaryTree.postOrderTraversal(BinaryTree.root);
        System.out.println();

        System.out.println("depth of the Binary Tree :- " + BinaryTree.depth(BinaryTree.root));
        System.out.println("height of the Binary Tree :- " + BinaryTree.height(BinaryTree.root));
    }
}
