package Trees.StandardQuestions;

import Trees.TreeNode;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int diff = Math.abs(
                MaxDepthOfBinaryTree.maxDepth(root.left) -
                        MaxDepthOfBinaryTree.maxDepth(root.right)
        );

        boolean isBalancedCheck =
                isBalanced(root.left) &&
                        isBalanced(root.right);

        if (diff <= 1 && isBalancedCheck) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(9);
        TreeNode three = new TreeNode(20);
        TreeNode four = new TreeNode(15);
        TreeNode five = new TreeNode(7);

        one.left = two;
        one.right = three;

        three.left = four;
        three.right = five;

        TreeNode.root = one;

        System.out.println("Is the Tree Balanced ? :- " + isBalanced(TreeNode.root));
    }
}
