package Trees.StandardQuestions;

import Trees.TreeNode;

public class SymmetricTree {
    public static boolean SymmetricTreeUtil(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.val == q.val && SymmetricTreeUtil(p.left,q.right) == true && SymmetricTreeUtil(p.right, q.left) == true){
            return true;
        }else{
            return false;
        }

    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return SymmetricTreeUtil(root.left, root.right) && SymmetricTreeUtil(root.right , root.left);

    }

    public static void main(String[] args){
        Integer[] arr = {1,2,2,3,4,4,3};

        TreeNode ans = TreeNode.buildTree(arr);

        System.out.println("Is Tree Symmetric ? :- " + isSymmetric(ans));
    }
}
