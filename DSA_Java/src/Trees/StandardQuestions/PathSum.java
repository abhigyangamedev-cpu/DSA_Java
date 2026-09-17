package Trees.StandardQuestions;

import Trees.TreeNode;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        if(root.left == null && root.right == null){
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }

    public static void main(String[] args){
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode ans = TreeNode.buildTree(arr);

        System.out.println("Has the target sum ?- " + hasPathSum(ans,22
        ));
    }
}
