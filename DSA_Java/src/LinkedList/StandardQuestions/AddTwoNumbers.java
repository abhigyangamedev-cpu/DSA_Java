package LinkedList.StandardQuestions;

import LinkedList.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int sum = 0;
        int carry = 0;

        while(l1 != null || l2 != null){
            int p;

            if(l1 == null){
                p = 0;
            }else{
                p = l1.val;
            }

            int q;

            if(l2 == null){
                q = 0;
            }else{
                q = l2.val;
            }

            sum = p + q + carry;
            carry = sum/10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(l1 == null){
                l1 = null;
            }else{
                l1 = l1.next;
            }

            if(l2 == null){
                l2 = null;
            }else{
                l2 = l2.next;
            }
        }

        if(carry > 0){
            curr.next = new ListNode(1);
        }

        return dummyHead.next;

    }

    public static void main(String[] args){

        ListNode l1two = new ListNode(2);
        ListNode l1four = new ListNode(4);
        ListNode l1three = new ListNode(3);

        l1two.next = l1four;
        l1four.next = l1three;

        ListNode l2five = new ListNode(5);
        ListNode l2six = new ListNode(6);
        ListNode l2four = new ListNode(4);

        l2five.next = l2six;
        l2six.next = l2four;

        ListNode ans = addTwoNumbers(l1two,l2five);
        ListNode.printList(ans);

    }
}
