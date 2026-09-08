package LinkedList.ProblemSet.Easy.CodeChef;

import LinkedList.ListNode;


public class FindTheLengthOfTheLinkedList {
    public static int getLength(ListNode head) {
        //write code here...
        if(head == null) return 0;

        ListNode  curr = head;

        int count = 0;

        while(curr != null){
            curr = curr.next;
            count++;
        }

        return count;
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

        System.out.println(getLength(ListNode.head));
    }
}
