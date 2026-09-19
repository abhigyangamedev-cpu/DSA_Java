package Stacks;

public class StackNode {

    int val;
    StackNode next;

    public StackNode(int val) {
        this.val = val;
        this.next = null;
    }

    public StackNode(int val, StackNode next) {
        this.val = val;
        this.next = next;
    }

    public static class Stack {

        private StackNode head = null;

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int value) {
            head = new StackNode(value, head);
        }

        public void pop() {
            if (!isEmpty()) {
                int result = head.val;
                head = head.next;

                System.out.println("Removed " + result);
            } else {
                System.out.println("Stack is Empty");
            }
        }

        public int peak() {
            if (!isEmpty()) {
                return head.val;
            }

            return Integer.MIN_VALUE;
        }

        public int top() {
            return peak();
        }

        public static void main(String[] args) {

            Stack stack = new Stack();

            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);

            System.out.println("Top element :- " + stack.top());

            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        }
    }
}

