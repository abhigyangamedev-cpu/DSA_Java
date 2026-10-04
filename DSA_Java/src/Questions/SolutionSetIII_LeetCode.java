package Questions;

import Trees.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SolutionSetIII_LeetCode {

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
        // Q1
        public boolean isSymmetric(TreeNode root) {

            if(root == null) return true;

            return isMirrorTree(root.left,root.right) && isMirrorTree(root.right,root.left);

        }
        public boolean isMirrorTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;

            if(p == null || q == null) return false;

            if(p.val == q.val && ( isMirrorTree(p.left,q.right) == true && isMirrorTree(p.right, q.left) == true )){
                return true;
            }else{
                return false;
            }
        }

        // Q2
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;

            int maxDepthLeft = maxDepth(root.left);
            int maxDepthRight = maxDepth(root.right);

            return 1 + Math.max(maxDepthLeft, maxDepthRight);
        }
        public boolean isBalanced(TreeNode root) {
            if(root == null) return true;

            int diff = Math.abs(maxDepth(root.left) - maxDepth(root.right));
            boolean isBalancedCheck = isBalanced(root.left) && isBalanced(root.right);

            if(diff <= 1 && isBalancedCheck == true){
                return true;
            }else{
                return false;
            }
        }

        // Q3
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList();
            List<Integer> solution = new ArrayList<Integer>();
            pathSum(root, targetSum, solution, result);
            return result;

        }
        void pathSum(TreeNode root, int sum, List<Integer> solution, List<List<Integer>> result){
            if(root == null){
                return;
            }

            solution.add(root.val);

            if(root.left == null && root.right == null && sum == root.val){
                result.add(new ArrayList<Integer>(solution));
            }else{
                pathSum(root.left,sum - root.val, solution,result);
                pathSum(root.right, sum - root.val, solution, result);
            }

            solution.remove(solution.size() - 1);
        }

        // Q4
        public boolean validateStackSequences(int[] pushed, int[] popped) {

            if(pushed.length == 1) return pushed[0] == popped[0];

            int popIndex = 0;
            Stack<Integer> st = new Stack<>();

            for(int ele : pushed){
                st.push(ele);

                while(!st.isEmpty() && st.peek() == popped[popIndex]){
                    st.pop();
                    popIndex++;
                }
            }
            return st.isEmpty();

        }
    }

    class FourMarks{

        // Q1
        public List<Integer> inorderTraversal(TreeNode root){
            List<Integer> result = new LinkedList<>();

            if(root == null){
                return result;
            }

            Stack<TreeNode> st = new Stack<>();
            TreeNode curr = root;

            while(curr != null || !st.isEmpty()){
                while(curr != null){
                    st.push(curr);
                    curr = curr.left;
                }

                curr = st.pop();
                result.add(curr.val);

                curr = curr.right;
            }

            return result;
        }

        // Q2
        public boolean isValidBST(TreeNode root) {
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

        // Q3
        public boolean validateStackSequences(int[] pushed, int[] popped) {

            if(pushed.length == 1) return pushed[0] == popped[0];

            int popIndex = 0;

            Stack<Integer> st = new Stack<>();

            for(int ele : pushed){
                st.push(ele);

                while(!st.isEmpty() && st.peek() == popped[popIndex]){
                    st.pop();
                    popIndex++;
                }
            }

            return st.isEmpty();

        }

        // Q4
        public boolean isValid(String s) {
            if (s.length() % 3 != 0) {
                return false;
            }

            Stack<Character> st = new Stack<>();

            //Enhanced for - loop
            for(char ch: s.toCharArray()) {
                if(ch == 'c') {
                    if(st.size() >=2 && st.pop()=='b' && st.pop()=='a') {
                        continue; //do nothing;
                    } else {
                        return false;
                    }
                } else {
                    //Push for a and b elements
                    st.push(ch);
                }
            }
            return st.isEmpty();
        }
    
    }

}
