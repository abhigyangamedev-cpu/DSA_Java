package LinkedList.StandardQuestions;

import LinkedList.ListNode;

public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head , fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

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

        ListNode ans = detectCycle(ListNode.head);

        if(ans != null){
            System.out.println("Cycle starts at: " + ans.val);
        } else {
            System.out.println("No cycle");
        }
    }
}
