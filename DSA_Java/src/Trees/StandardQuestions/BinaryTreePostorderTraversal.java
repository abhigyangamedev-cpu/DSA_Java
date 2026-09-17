package Trees.StandardQuestions;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;

    }

    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = TreeNode.buildTree(arr);

        List<Integer> result = postorderTraversal(root);

        for(Integer x : result){
            System.out.print(x + " ");
        }
    }
}
