package Trees.Codechef.Trees;

public class BST {

    static class BSTNode {

        int val;
        static BSTNode root;
        BSTNode left;
        BSTNode right;

        BSTNode() {}

        BSTNode(int val) {
            this.val = val;
        }

        public static void insert(int element) {

            if (root == null) {
                root = new BSTNode(element);
                return;
            }

            BSTNode curr = root;

            while (true) {

                if (element < curr.val) {

                    if (curr.left == null) {
                        System.out.printf(
                                "Inserting %d in left of %d\n",
                                element, curr.val
                        );

                        curr.left = new BSTNode(element);
                        break;

                    } else {
                        curr = curr.left;
                    }

                } else {

                    if (curr.right == null) {
                        System.out.printf(
                                "Inserting %d in right of %d\n",
                                element, curr.val
                        );

                        curr.right = new BSTNode(element);
                        break;

                    } else {
                        curr = curr.right;
                    }
                }
            }
        }

        public static boolean search(BSTNode root, int element){
            if(root == null) return false;

            if(root.val == element) return true;

            if(root.val > element){
                return search(root.left,element);
            }else {
                return search(root.right,element);
            }
        }

        public static int valueOfMaxNode(BSTNode root){
            BSTNode curr = root;
            while (curr.right != null){
                curr = curr.right;
            }
            return curr.val;
        }
    }

    public static void main(String[] args) {

        int[] arr = {8, 3, 1, 6, 10, 14};

        for (int element : arr) {
            BSTNode.insert(element);
        }

        System.out.println("\nInorder Traversal:");

        printInorder(BSTNode.root);

        System.out.println("Is the element present in BST :- " + BSTNode.search(BSTNode.root,3));
        System.out.println("Is the element present in BST :- " + BSTNode.search(BSTNode.root,11));

        System.out.println("Maximum value node of the BST :- " + BSTNode.valueOfMaxNode(BSTNode.root));
    }

    static void printInorder(BSTNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
