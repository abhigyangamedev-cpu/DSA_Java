package Questions;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionSetIII {

    class TwoMarks{
        // Q1
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            if(root == null) return result;

            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));

            return result;
        }

        // Q2
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;

            if(p == null || q == null) return false;

            if(p.val == q.val && ( isSameTree(p.left,q.left) == true && isSameTree(p.right, q.right) == true )){
                return true;
            }else{
                return false;
            }
        }

        // Q3
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;

            int maxDepthLeft = maxDepth(root.left);
            int maxDepthRight = maxDepth(root.right);

            return 1 + Math.max(maxDepthLeft, maxDepthRight);
        }

        // Q4
        public boolean hasPathSum(TreeNode root, int targetSum) {

            if(root == null) return false;

            if(root.left == null && root.right == null) return targetSum == root.val;

            return hasPathSum(root.left , targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }

        // Q5
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            if(root == null) return result;

            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));

            return result;
        }

        // Q6
        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            if(root == null) return result;

            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);

            return result;
        }
    }

    class ThreeMarks{

    }

}
