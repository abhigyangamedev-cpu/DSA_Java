package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class SwappingNodesInALinkedList {
    public static ListNode swapNodes(ListNode head, int k) {

        ListNode slow = head, fast = head, first = head , second = head;

        for(int i = 0; i < k - 1; i++){
            fast = fast.next;
        }

        first = fast;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        second = slow;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }

    public static void main(String[] args){
        // Create: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode.ListNodeMethods.printList(head);

        head = swapNodes(head, 2);

        ListNode.ListNodeMethods.printList(head);
    }
}
