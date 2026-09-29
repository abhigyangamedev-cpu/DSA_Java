package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode slist = new ListNode();
        ListNode blist = new ListNode();
        ListNode small = slist;
        ListNode big = blist;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }

            head = head.next;
        }

        small.next = blist.next;
        big.next = null;

        return slist.next;
    }

    public static void main(String[] args){
        // head = [1,4,3,2,5,2]
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        head = partition(head,3);

        ListNode.ListNodeMethods.printList(head);
    }
}
