package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class MergeNodesInBetweenZeroes {
    public static ListNode mergeNodes(ListNode head) {

        ListNode curr = head;

        while(curr.next != null){
            ListNode node = curr.next;
            curr = curr.next;

            while(curr.next.val != 0){
                node.val += curr.next.val;
                curr = curr.next;
            }

            curr = curr.next;
            node.next = curr.next;
        }

        return head.next;

    }

    public static void main(String[] args) {

        ListNode Head = new ListNode(0);

        Head.next = new ListNode(3);
        Head.next.next = new ListNode(1);
        Head.next.next.next = new ListNode(0);
        Head.next.next.next.next = new ListNode(4);
        Head.next.next.next.next.next = new ListNode(5);
        Head.next.next.next.next.next.next = new ListNode(2);
        Head.next.next.next.next.next.next.next = new ListNode(0);

        ListNode.head = Head;

        ListNode ans = mergeNodes(Head);

        ListNode.ListNodeMethods.printList(ans);
    }
}
