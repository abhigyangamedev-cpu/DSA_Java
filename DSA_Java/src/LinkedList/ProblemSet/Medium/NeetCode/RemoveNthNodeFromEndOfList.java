package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null) return null;

        ListNode curr = head;
        ListNode temp = head;

        int i = 1;
        while(i <= n){
            curr = curr.next;
            i++;
        }

        if(curr == null) return head.next;

        while(curr.next != null){
            curr = curr.next;
            temp = temp.next;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
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

        ListNode.head = removeNthFromEnd(ListNode.head,2);

        ListNode.ListNodeMethods.printList(ListNode.head);
    }
}
