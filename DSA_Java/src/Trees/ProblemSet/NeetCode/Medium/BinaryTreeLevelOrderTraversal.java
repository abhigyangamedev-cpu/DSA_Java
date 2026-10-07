package Trees.ProblemSet.NeetCode.Medium;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        int height = maxDepth(root);

        for (int level = 1; level <= height; level++) {
            List<Integer> currentLevel = new ArrayList<>();
            getLevel(root, level, currentLevel);
            result.add(currentLevel);
        }

        return result;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(
                maxDepth(root.left),
                maxDepth(root.right)
        );
    }

    public static void getLevel(
            TreeNode root,
            int level,
            List<Integer> currentLevel
    ) {
        if (root == null) return;

        if (level == 1) {
            currentLevel.add(root.val);
            return;
        }

        getLevel(root.left, level - 1, currentLevel);
        getLevel(root.right, level - 1, currentLevel);
    }

    public static void main(String[] args){
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTree(arr);
        List<List<Integer>> result = levelOrder(root);
        System.out.print(result);
    }
}
