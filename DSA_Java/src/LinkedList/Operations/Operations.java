package LinkedList.Operations;

import LinkedList.ListNode;
import LinkedList.ProblemSet.Basics.DoublyLinkedList;

public class Operations {

    private static int lengthOfLinkedList(ListNode head) {
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }
    private static ListNode deleteValue(int val) {
        if (ListNode.head == null) {
            return null;
        }

        if (ListNode.head.val == val) {
            ListNode.head = ListNode.head.next;
            return ListNode.head;
        }

        ListNode curr = ListNode.head;

        while (curr.next != null && curr.next.val != val) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        } else {
            System.out.println("Value Not Found");
        }

        return ListNode.head;
    }
    private static void deleteList() {
        ListNode.head = null;
    }
    private static ListNode getNthNodeFromStart(int n) {
        if (ListNode.head == null || n <= 0) {
            return null;
        }

        ListNode curr = ListNode.head;

        for (int i = 1; i < n; i++) {
            if (curr == null) {
                return null;
            }

            curr = curr.next;
        }

        return curr;
    }
    private static ListNode getNthNodeFromEnd(int n) {
        if (ListNode.head == null || n >= 0) {
            return null;
        }

        int position = -n;

        ListNode fast = ListNode.head;
        ListNode slow = ListNode.head;

        for (int i = 0; i < position; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    private static int sizeOfDoublyLinkedList(DoublyLinkedList head) {
        int count = 0;
        DoublyLinkedList curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public static void main(String[] args) {

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

        System.out.println("Printing the List:");
        ListNode.printList(ListNode.head);

        System.out.println(
                "Length of Linked List: " +
                        lengthOfLinkedList(ListNode.head)
        );

        System.out.println("\nDeleting the element 2:");
        deleteValue(2);
        ListNode.printList(ListNode.head);

        ListNode secondNodeFromStart = getNthNodeFromStart(2);

        System.out.println(
                "\n2nd Node From Start: " +
                        (secondNodeFromStart != null
                                ? secondNodeFromStart.val
                                : "Not Found")
        );

        ListNode secondNodeFromEnd = getNthNodeFromEnd(-2);

        System.out.println(
                "2nd Node From End: " +
                        (secondNodeFromEnd != null
                                ? secondNodeFromEnd.val
                                : "Not Found")
        );

        deleteList();

        System.out.println("\nAfter deleting the entire List:");
        ListNode.printList(ListNode.head);

        DoublyLinkedList d_one = new DoublyLinkedList(1);
        DoublyLinkedList d_two = new DoublyLinkedList(2);
        DoublyLinkedList d_three = new DoublyLinkedList(3);
        DoublyLinkedList d_four = new DoublyLinkedList(4);
        DoublyLinkedList d_five = new DoublyLinkedList(5);

        d_one.next = d_two;
        d_two.prev = d_one;

        d_two.next = d_three;
        d_three.prev = d_two;

        d_three.next = d_four;
        d_four.prev = d_three;

        d_four.next = d_five;
        d_five.prev = d_four;

        DoublyLinkedList.head = d_one;

        System.out.println("\nPrinting the Doubly Linked List:");
        DoublyLinkedList.TraversalForward(DoublyLinkedList.head);

        System.out.println(
                "Printing the size of the Doubly Linked List: " +
                        sizeOfDoublyLinkedList(DoublyLinkedList.head)
        );
    }
}