package LinkedList.StandardQuestions;

import LinkedList.ListNode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode Head = null;

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            Head = list1;
            list1 = list1.next;
        }else{
            Head = list2;
            list2 = list2.next;
        }

        ListNode curr = Head;

        while(list1 != null && list2 != null){

            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if(list1 == null){
            curr.next = list2;
        }else{
            curr.next = list1;
        }

        return Head;
    }

    public static void main(String[] args){
        ListNode l1one = new ListNode(1);
        ListNode l1two = new ListNode(2);
        ListNode l1four = new ListNode(4);

        l1one.next = l1two;
        l1two.next = l1four;

        ListNode l2one = new ListNode(1);
        ListNode l2three = new ListNode(3);
        ListNode l2four = new ListNode(4);

        l2one.next = l2three;
        l2three.next = l2four;

        ListNode ans = mergeTwoLists(l1one,l2one);
        ListNode.printList(ans);
    }
}
