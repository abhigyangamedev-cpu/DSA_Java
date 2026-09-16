package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class RemoveNodesFromLinkedList {
    public static ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode future = curr.next;

        while(future != null){
            curr.next = prev;
            prev = curr;
            curr = future;
            future = future.next;

        }

        curr.next = prev;

        prev = curr;

        ListNode checker = curr.next;

        while(checker != null){
            if(checker.val >= prev.val){
                prev.next = checker;
                prev = checker;
            }
            checker = checker.next;
        }

        prev.next = null;
        prev = prev.next;
        future = curr.next;

        while(future != null){
            curr.next = prev;
            prev = curr;
            curr = future;
            future = future.next;
        }

        curr.next = prev;

        return curr;
    }

    public static void main(String[] args){

        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.head = node1;

        ListNode ans = removeNodes(ListNode.head);

        ListNode.ListNodeMethods.printList(ans);

    }
}
