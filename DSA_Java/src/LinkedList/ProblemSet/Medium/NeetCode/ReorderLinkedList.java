package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class ReorderLinkedList {
    public static void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        // Step 1: Find Middle

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split List

        ListNode second = slow.next;
        slow.next = null;

        // Step 3: Reverse Second Half

        ListNode prev = null;

        while(second != null){

            ListNode next = second.next;

            second.next = prev;

            prev = second;
            second = next;
        }

        second = prev;

        // Step 4: Merge Both Halves

        ListNode first = head;

        while(second != null){

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode.head = one;

        ListNode.ListNodeMethods.printList(ListNode.head);

        reorderList(ListNode.head);

        ListNode.ListNodeMethods.printList(ListNode.head);
    }
}
