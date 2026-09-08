package LinkedList.ProblemSet.NeetCode;

import LinkedList.ListNode;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(0,head);
        ListNode dummy = ans;

        while(dummy != null){
            while(dummy.next != null && dummy.next.val == val){
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }

        return ans.next;
    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode six = new ListNode(6);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six_2 = new ListNode(6);

        one.next = two;
        two.next = six;
        six.next = three;
        three.next = four;
        four.next = five;
        five.next = six_2;

        ListNode.head = one;

        ListNode ans = removeElements(ListNode.head,6);

        System.out.println("Printing the new Linked List after removing Elements");
        ListNode.printList(ListNode.head);
    }


}
