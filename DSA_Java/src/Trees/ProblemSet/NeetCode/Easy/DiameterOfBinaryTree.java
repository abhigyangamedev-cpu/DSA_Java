package Trees.ProblemSet.NeetCode.Easy;

import Trees.TreeNode;

public class DiameterOfBinaryTree {
    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int maxDepthLeft = maxDepth(root.left);
        int maxDepthRight = maxDepth(root.right);

        diameter = Math.max(diameter, maxDepthLeft + maxDepthRight);

        return 1 + Math.max(maxDepthLeft, maxDepthRight);
    }

    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5};
        TreeNode root = TreeNode.buildTree(arr);

        System.out.println("Diamter of the following tree is :- " + diameterOfBinaryTree(root));
    }
}
