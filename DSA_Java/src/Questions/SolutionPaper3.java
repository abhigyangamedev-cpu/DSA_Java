package Questions;

import Trees.TreeNode;
import LinkedList.ListNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SolutionPaper3 {
    // Set 1
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

    // Set 2
    static class FiveMarks{

        // Q1
        static class StackNode{

            int val;
            StackNode next;
            static StackNode head;

            public StackNode() {
            }

            StackNode(int val, StackNode next){
                this.val = val;
                this.next = next;
            }


            static boolean isEmpty(){ return head == null;}

            static void push(int value){ head = new StackNode(value, head);}

            static void pop(){

                if(!isEmpty()){
                    int result = head.val;
                    head = head.next;
                    System.out.println("Removed :- " + result);
                }else{
                    System.out.println("Stack is Empty");
                }
            }

            static int peak(){
                if(!isEmpty()) return head.val;
                return Integer.MIN_VALUE;
            }

            static int top(){ return peak();}

            static void runStackNode(){

                StackNode st = new StackNode();

                st.push(1);
                st.push(2);
                st.push(3);
                st.push(4);

                System.out.println("Top element of the stack :- " + st.top());

                st.pop();
                st.pop();
                st.pop();
                st.pop();
                st.pop();
            }
        }

        // Q2
        static class Queue{

            static ListNode rear , front;

            static boolean isEmpty(){
                if (front == null) return true;
                return false;
            }

            static void enqueue(int val){
                ListNode newNode = new ListNode(val);

                if(rear == null){
                    front = rear = newNode;
                    return;
                }

                rear.next = newNode;
                rear = newNode;
            }

            static int dequeue(){

                if(front == null) return -1;

                int data = front.val;
                front = front.next;

                if(front == null) rear = null;

                return data;
            }

            static int peak(){
                if(front == null) return Integer.MIN_VALUE;
                return front.val;
            }

            static void display(){
                ListNode curr = front;

                System.out.println("Displaying the queue implementation using Linked List");

                while(curr != null){
                    System.out.print(curr.val + "->");
                    curr = curr.next;
                }
                System.out.println("null");
            }

            static void runQueueImplementation(){

                Queue q = new Queue();

                System.out.println("Is Queue Empty ? :- " + isEmpty());

                q.enqueue(1);
                q.enqueue(2);
                q.enqueue(3);
                q.enqueue(4);
                q.enqueue(5);

                System.out.println("Peak element of the queue :- " + q.peak());
                System.out.println("Is Queue Empty After enqueueing  ? :- " + isEmpty());
                q.display();

                System.out.println("Dequeued :- " + q.dequeue());
                System.out.println("Dequeued :- " + q.dequeue());
                System.out.println("Dequeued :- " + q.dequeue());
                System.out.println("Dequeued :- " + q.dequeue());
                System.out.println("Dequeued :- " + q.dequeue());
                System.out.println("Dequeued :- " + q.dequeue());

                System.out.println("Is Queue Empty After dequeueing ? :- " + isEmpty());

            }

        }

        // Q3
        static class TreeNode{

            int val;
            static TreeNode root;
            TreeNode left;
            TreeNode right;

            TreeNode(){}

            TreeNode(int val){this.val = val;}

            TreeNode(int val, TreeNode left,TreeNode right){
                this.val = val;
                this.left = left;
                this.right = right;
            }

            static void preOrder(TreeNode root){
                if(root == null) return;

                System.out.print(root.val +" ");
                preOrder(root.left);
                preOrder(root.right);
            }

            static void inOrder(TreeNode root){
                if(root == null) return;

                inOrder(root.left);
                System.out.print(root.val +" ");
                inOrder(root.right);
            }

            static void postOrder(TreeNode root){
                if(root == null) return;


                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.val +" ");
            }

            static void runTreeNode(){

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
                two.right= five;

                three.left = six;
                three.right = seven;

                root = one;

                System.out.println("PreOrder Traversal");
                preOrder(root);
                System.out.println();
                System.out.println("InOrder Traversal");
                inOrder(root);
                System.out.println();
                System.out.println("PostOrder Traversal");
                postOrder(root);
                System.out.println();
            }
        }

        // Q4
        static class BST {
            static TreeNode root;

            static TreeNode insertRecord(TreeNode node, int val) {

                if(node == null) {
                    return new TreeNode(val);
                }

                if(val <= node.val) {
                    node.left = insertRecord(node.left, val);
                } else {
                    node.right = insertRecord(node.right, val);
                }

                return node;
            }

            static void insert(int val) {
                root = insertRecord(root, val);
            }

            static boolean search(TreeNode root, int val) {

                if(root == null) return false;

                if(root.val == val) {
                    return true;
                } else if(val < root.val) {
                    return search(root.left, val);
                } else {
                    return search(root.right, val);
                }
            }

            static void inOrder(TreeNode root){

                if(root == null) return;

                inOrder(root.left);
                System.out.print(root.val +" ");
                inOrder(root.right);
            }

            static void runBST() {

                insert(50);
                insert(30);
                insert(70);
                insert(20);
                insert(40);
                insert(60);
                insert(80);

                System.out.println("Search 40: " + search(root, 40));
                System.out.println("Search 90: " + search(root, 90));

                System.out.println("InOrder Traversal for BST");
                inOrder(root);
            }
        }
    }
    public static void main(String[] args){
        FiveMarks.StackNode.runStackNode();
        FiveMarks.Queue.runQueueImplementation();
        FiveMarks.TreeNode.runTreeNode();
        FiveMarks.BST.runBST();

    }
}
