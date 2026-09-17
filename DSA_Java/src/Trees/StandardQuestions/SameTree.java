package Trees.StandardQuestions;

import Trees.TreeNode;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.val == q.val && isSameTree(p.left,q.left) == true && isSameTree(p.right, q.right) == true){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args){
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {1,2,3};

        TreeNode p = TreeNode.buildTree(arr1);
        TreeNode q = TreeNode.buildTree(arr2);

        System.out.println("Is Tree same ? :- " + isSameTree(p,q));
    }
}
