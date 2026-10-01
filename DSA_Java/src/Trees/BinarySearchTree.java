package Trees;

import java.util.Stack;

public class BinarySearchTree {

    static TreeNode root;

    public static void insert(int val){
        root = insertRecord(root,val);
    }

    public static TreeNode insertRecord(TreeNode node, int val){
        if(node == null){
            node = new TreeNode(val);
            return node;
        }

        if(val <= node.val){
            node.left = insertRecord(node.left, val);
        }else{
            node.right = insertRecord(node.right, val);
        }

        return node;
    }

    public static boolean search(TreeNode root, int val){
        if(root == null) return false;

        if(root.val == val){
            return true;
        }else if( val < root.val){
            return search(root.left, val);
        }else{
            return search(root.right, val);
        }

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;

        while(curr != null || !st.isEmpty()){
            // Push onto the stack the left nodes to reach the left most node
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }

            // Capturing the root node ( Left Root Right )
            curr = st.pop();

            // Comparing the previous node with the current node
            if(pre != null && curr.val <= pre.val){
                return false;
            }

            pre = curr;

            // Traverse to the right nodes
            curr = curr.right;
        }

        return true;
    }

    public static void main(String[] args){
        Integer[] arr = {
                50, 30, 70, 20, 40, 60, 80
        };

        root = TreeNode.buildTree(arr);

        System.out.println("Is the value in the tree :- " + search(root,50));
        System.out.println("Is the value in the tree :- " + search(root,150));

        System.out.println("Is it a valid BST :- " + isValidBST(root));
    }
}
