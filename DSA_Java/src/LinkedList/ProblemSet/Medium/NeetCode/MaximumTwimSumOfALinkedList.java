package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class MaximumTwimSumOfALinkedList {
    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        int sum = 0;

        while(slow != null){
            sum = Math.max(sum, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;

        }

        return sum;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        System.out.println("Sum :- " + pairSum(head));
    }
}
