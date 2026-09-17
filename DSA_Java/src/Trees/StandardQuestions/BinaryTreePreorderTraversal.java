package Trees.StandardQuestions;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));


        return result;

    }

    public static void main(String[] args){
        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = TreeNode.buildTree(arr);

        List<Integer> result = preorderTraversal(root);

        for(Integer x : result){
            System.out.print(x + " ");
        }
    }
}
