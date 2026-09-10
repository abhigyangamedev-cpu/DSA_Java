package LinkedList.ProblemSet.Easy.NeetCode;

import LinkedList.ListNode;

public class MiddleOfALinkedList {
    public static ListNode middleNode(ListNode head) {
        if(head == null ) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;

        ListNode.head = one;

        ListNode ans = middleNode(ListNode.head);

        ListNode.ListNodeMethods.printList(ans);
    }
}
