package LinkedList.ProblemSet.NeetCode;

import LinkedList.ListNode;

public class IntersectionOfTwoLinkedList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while(currA != currB){
            if(currA != null){
                currA = currA.next;
            }else{
                currA = headB;
            }

            if(currB != null){
                currB = currB.next;
            }else{
                currB = headA;
            }
        }

        return currA;

    }


    public static void main(String[] args) {

        // Common nodes (intersection)
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);

        two.next = four;

        // List A: 1 → 9 → 1 → 2 → 4
        ListNode oneA = new ListNode(1);
        ListNode nine = new ListNode(9);
        ListNode oneA2 = new ListNode(1);

        oneA.next = nine;
        nine.next = oneA2;
        oneA2.next = two;   // Connect A to intersection

        // List B: 3 → 2 → 4
        ListNode three = new ListNode(3);

        three.next = two;   // Connect B to SAME intersection

        ListNode headA = oneA;
        ListNode headB = three;

        // Find intersection
        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersected at '" + intersection.val + "'");
        } else {
            System.out.println("No intersection");
        }
    }
}
