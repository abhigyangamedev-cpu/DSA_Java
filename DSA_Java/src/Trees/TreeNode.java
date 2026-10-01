package Trees;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

    public int val;
    public static TreeNode root;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void preOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.val + "->");

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.val + "->");
        inOrder(node.right);
    }

    public void postOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "->");
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();

        if(root == null){
            return result;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            // Push onto the stack the left nodes to reach the left most node
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }

            // Capturing the root node ( Left Root Right )
            curr = st.pop();
            result.add(curr.val);

            // Traverse to the right nodes
            curr = curr.right;
        }

        return result;
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode obj = new TreeNode();

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        root = one;

        System.out.println("Preorder:");
        obj.preOrder(root);
        System.out.println("null");

        System.out.println("Inorder:");
        obj.inOrder(root);
        System.out.println("null");

        System.out.println("Postorder:");
        obj.postOrder(root);
        System.out.println("null");

        System.out.println("Iterative Inorder ");
        List<Integer> result = inorderTraversal(root);

        for(int ele : result){
            System.out.print(ele + " ");
        }
    }
}