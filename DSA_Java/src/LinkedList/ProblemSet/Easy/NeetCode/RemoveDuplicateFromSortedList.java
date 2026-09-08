package LinkedList.ProblemSet.Easy.NeetCode;

import LinkedList.ListNode;

public class RemoveDuplicateFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;

        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;

    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode one_2 = new ListNode(1);
        ListNode two = new ListNode(2);

        one.next = one_2;
        one_2.next = two;

        ListNode.head = one;

        ListNode ans = deleteDuplicates(ListNode.head);
        ListNode.printList(ans);
    }
}
