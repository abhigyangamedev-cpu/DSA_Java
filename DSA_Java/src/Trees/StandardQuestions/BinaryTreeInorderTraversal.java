package Trees.StandardQuestions;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));

        return result;
    }

    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = TreeNode.buildTree(arr);

        List<Integer> result = inorderTraversal(root);

        for (Integer x : result) {
            System.out.print(x + " ");
        }
    }
}
