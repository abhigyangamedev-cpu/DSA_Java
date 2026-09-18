package Trees.StandardQuestions;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> solution = new ArrayList<Integer>();
        pathSum(root, targetSum, solution, result);
        return result;

    }

    static void pathSum(TreeNode root, int sum, List<Integer> solution, List<List<Integer>> result){
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

    public static void main(String[] args){
        Integer arr[] = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNode.buildTree(arr);
        List<List<Integer>> result = pathSum(root,22);

        System.out.println(result);
    }
}
