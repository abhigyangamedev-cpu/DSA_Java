package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;


        ListNode dummy = new ListNode(0);

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr!= null && curr.next != null){
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        ListNode.head = one;

        ListNode.ListNodeMethods.printList(ListNode.head);

        ListNode.head = swapPairs(ListNode.head);

        ListNode.ListNodeMethods.printList(ListNode.head);


    }
}
