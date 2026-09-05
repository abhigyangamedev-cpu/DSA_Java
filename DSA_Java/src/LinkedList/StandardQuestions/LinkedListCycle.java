package LinkedList.StandardQuestions;

import LinkedList.ListNode;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode minus_four = new ListNode(-4);

        three.next = two;
        two.next = zero;
        zero.next = minus_four;
        minus_four.next = two;

        ListNode.head = three;

        System.out.println(hasCycle(ListNode.head));
    }
}
