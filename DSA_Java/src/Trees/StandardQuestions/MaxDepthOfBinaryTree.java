package Trees.StandardQuestions;

import Trees.TreeNode;

public class MaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int MaxDepthLeft = maxDepth(root.left);
        int MaxDepthRight = maxDepth(root.right);

        return 1 + Math.max(MaxDepthLeft,MaxDepthRight);
    }

    public static void main(String[] args){
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        TreeNode.root = one;

        System.out.println("Maximum depth of the tree :- " + maxDepth(TreeNode.root));
    }
}
