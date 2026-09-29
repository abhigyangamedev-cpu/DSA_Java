package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class AddTwoNumbersII {
    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode temp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Reverse both linked lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int p;

            if (l1 == null) {
                p = 0;
            } else {
                p = l1.val;
            }

            int q;

            if (l2 == null) {
                q = 0;
            } else {
                q = l2.val;
            }

            int sum = p + q + carry;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        // Reverse the answer
        return reverse(dummyHead.next);
    }

    public static void main(String[] args){
        // l1 = 7 → 2 → 4 → 3
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        // l2 = 5 → 6 → 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add the two numbers
        ListNode result = addTwoNumbers(l1, l2);

        ListNode.ListNodeMethods.printList(result);
    }
}
