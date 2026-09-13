package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

public class MergeInBetweenLinkedList {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode slow = list1;
        ListNode fast = list1;

        for(int i = 1; i <= b ; i++){
            if( i > a -1){
                fast = fast.next;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
        }

        slow.next = list2;

        while(slow != null && slow.next != null){
            slow = slow.next;
        }

        slow.next = fast.next;
        return list1;
    }

    public static void main(String[] args){
        int[] arr1 = {10,1,13,6,9,5};
        ListNode list1 = ListNode.ListNodeMethods.ArrayToLinkedList(arr1);
        ListNode.ListNodeMethods.printList(list1);

        int[] arr2 = {1000000,1000001,1000002};
        ListNode list2 = ListNode.ListNodeMethods.ArrayToLinkedList(arr2);
        ListNode.ListNodeMethods.printList(list2);

        ListNode ans = mergeInBetween(list1,3,4,list2);

        ListNode.ListNodeMethods.printList(ans);
    }
}
