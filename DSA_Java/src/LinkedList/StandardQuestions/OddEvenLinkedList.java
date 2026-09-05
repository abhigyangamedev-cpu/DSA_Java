package LinkedList.StandardQuestions;

import LinkedList.ListNode;

public class OddEvenLinkedList {
      public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode odd = head, even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
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

          ListNode ans = oddEvenList(ListNode.head);
          ListNode.printList(ans);
    }
}
