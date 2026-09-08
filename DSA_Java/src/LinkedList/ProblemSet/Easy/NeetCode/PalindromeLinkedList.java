package LinkedList.ProblemSet.Easy.NeetCode;

import LinkedList.ListNode;

public class PalindromeLinkedList {
    public static ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode middle = middleNode(head);
        ListNode secondHalf = reverse(middle);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args){
        ListNode Node1List1 = new ListNode(1);
        ListNode Node2List1 = new ListNode(2);
        ListNode Node3List1 = new ListNode(2);
        ListNode Node4List1 = new ListNode(1);

        Node1List1.next = Node2List1;
        Node2List1.next = Node3List1;
        Node3List1.next = Node4List1;

        System.out.println("Is it Palindrome :- " + isPalindrome(Node1List1));

        ListNode Node1List2 = new ListNode(1);
        ListNode Node2List2 = new ListNode(2);
        ListNode Node3List2 = new ListNode(3);
        ListNode Node4List2 = new ListNode(4);

        Node1List2.next = Node2List2;
        Node2List2.next = Node3List2;
        Node3List2.next = Node4List2;

        System.out.println("Is it Palindrome :- " + isPalindrome(Node1List2));
    }
}
