package LinkedList.ProblemSet.Medium.NeetCode;

import LinkedList.ListNode;

import java.util.ArrayList;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return new int[]{-1,-1};

        ArrayList<Integer> criticalPointsPositions = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode future = head.next.next;

        int position = 1;

        while(future != null){

            if((curr.val < prev.val && curr.val < future.val) || (curr.val > prev.val && curr.val > future.val)){
                criticalPointsPositions.add(position);
            }

            position++;

            prev = curr;
            curr = future;
            future = future.next;
        }

        if(criticalPointsPositions.size() < 2){
            return new int[]{-1,-1};
        }

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = 0;

        for(int i = 1; i <  criticalPointsPositions.size() ; i++){
            int distance = criticalPointsPositions.get(i) - criticalPointsPositions.get(i-1);
            minDistance = Math.min(distance,minDistance);
        }

        maxDistance = criticalPointsPositions.get(criticalPointsPositions.size()-1) - criticalPointsPositions.get(0);

        return new int[]{minDistance,maxDistance};

    }

    public static void main(String[] args){
        ListNode Head = new ListNode(5);

        Head.next = new ListNode(3);
        Head.next.next = new ListNode(1);
        Head.next.next.next = new ListNode(2);
        Head.next.next.next.next = new ListNode(5);
        Head.next.next.next.next.next = new ListNode(1);
        Head.next.next.next.next.next.next = new ListNode(2);

        ListNode.head = Head;

        int[] ans = nodesBetweenCriticalPoints(Head);

        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
