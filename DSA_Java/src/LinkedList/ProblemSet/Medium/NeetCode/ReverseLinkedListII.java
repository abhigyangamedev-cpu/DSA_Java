package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 0; i < left - 1; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for(int i = 0; i < right - left; i++){
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return head;
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

        ListNode.head = reverseBetween(ListNode.head,2,4);

        ListNode.ListNodeMethods.printList(ListNode.head);
    }
}
