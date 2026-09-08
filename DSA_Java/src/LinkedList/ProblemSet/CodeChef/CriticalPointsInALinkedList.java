package LinkedList.ProblemSet.CodeChef;

import LinkedList.ListNode;

public class CriticalPointsInALinkedList {
    static int solve(ListNode root){
        if(root == null || root.next == null || root.next.next == null) return 0;

        int criticalPoints = 0;
        ListNode prev = root;
        ListNode curr = root.next;
        ListNode future = root.next.next;

        while(future != null){
            if((curr.val > prev.val && curr.val > future.val) || (curr.val < prev.val && curr.val < future.val)) criticalPoints++;
            prev = curr;
            curr = future;
            future = future.next;
        }

        return criticalPoints;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(3);

        System.out.println(solve(head));
    }
}
