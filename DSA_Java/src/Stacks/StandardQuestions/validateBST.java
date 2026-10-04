package Stacks.StandardQuestions;

import Trees.BinarySearchTree;
import Trees.TreeNode;


import java.util.Stack;

public class validateBST {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;

        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();

            if(pre != null && curr.val <= pre.val){
                return false;
            }

            pre = curr;
            curr = curr.right;
        }

        return true;
    }

    public static void main(String[] args){
        Integer[] arr = {
                50, 30, 70, 20, 40, 60, 80
        };

        BinarySearchTree.root = TreeNode.buildTree(arr);
        System.out.println("Is it a valid BST :- " + isValidBST(BinarySearchTree.root ));
    }
}
