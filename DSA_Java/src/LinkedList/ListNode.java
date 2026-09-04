package LinkedList;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public static ListNode head;

    ListNode(){

    }

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head){
        ListNode curr = head;

        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        head = one;
        System.out.println("Printing Linked List");
        printList(head);

        ListNode zero = new ListNode(0);

        insertNodeAfterValue(1,zero);

        System.out.println("Printing Linked List after Adding node 0 after node 1");
        printList(head);

        ListNode four = new ListNode(4);

        insertAtIndex(2,four);

        System.out.println("Printing Linked List after Adding node 4 at index 2");
        printList(head);

        ListNode five = new ListNode(5);

        insertAtPosition(4,five);

        System.out.println("Printing Linked List after Adding node 5 at position 4");
        printList(head);

        deleteAtStart();

        System.out.println("Deleting at start");
        printList(head);

        deleteAtEnd();

        System.out.println("Deleting at end");
        printList(head);

        deleteAfterValue(4);

        System.out.println("Deleting after 4");
        printList(head);

        deleteAtIndex(2);

        System.out.println("Deleting after index 2");
        printList(head);

        deleteAtPosition(1);

        System.out.println("Deleting after position 1");
        printList(head);

        ListNode six = new ListNode(6);

        addAtStart(six);

        System.out.println("Adding at start");
        printList(head);

        ListNode seven = new ListNode(7);

        addAtEnd(seven);

        System.out.println("Adding at end");
        printList(head);

    }

    private static ListNode insertNodeAfterValue(int val, ListNode node){
        ListNode curr = head;

        while(curr != null && curr.val != val){
            curr = curr.next;
        }

        if(curr != null){
            node.next = curr.next;
            curr.next = node;
        }else System.out.println("Value Not Found");

        return head;
    }
    private static ListNode insertAtIndex(int index, ListNode node){
        ListNode curr = head;

        int counter = 0;

        while(curr != null && counter < index -1){
            curr = curr.next;
            counter++;
        }

        if(curr != null){
            node.next = curr.next;
            curr.next = node;
        }else System.out.println("Index Not Found");

        return head;
    }
    private static ListNode insertAtPosition(int position, ListNode node){
        ListNode curr = head;

        int counter = 1;

        while(curr != null && counter < position -1){
            curr = curr.next;
            counter++;
        }

        if(curr != null){
            node.next = curr.next;
            curr.next = node;
        }else System.out.println("Position Not Found");

        return head;
    }
    private static ListNode deleteAtStart(){
        if(head == null) return null;

        head = head.next;
        return head;
    }
    private static ListNode deleteAtEnd(){
        if(head == null && head.next == null) return null;

        ListNode curr = head;

        while( curr.next.next != null ){
            curr = curr.next;
        }

        curr.next = null;
        return head;
    }
    private static ListNode deleteAfterValue(int val){
        if(head == null){
            return null;
        }

        ListNode curr = head;

        while(curr != null && curr.val != val){
            curr= curr.next;
        }

        if(curr != null && curr.next != null){
            curr.next = curr.next.next;
        }else System.out.println("Value Not Found");

        return head;
    }
    private static ListNode deleteAtIndex(int index){
        if(head == null) return null;

        ListNode curr = head;

        int counter = 0;

        while(curr != null && counter < index -1){
            curr = curr.next;
            counter++;
        }

        if(curr != null && curr.next != null){
            curr.next = curr.next.next;
        }else System.out.println("Index Not Found");

        return head;
    }
    private static ListNode deleteAtPosition(int position){
        if(head == null) return null;

        ListNode curr = head;

        int counter = 1;

        while(curr != null && counter < position -1){
            curr = curr.next;
            counter++;
        }

        if(curr != null && curr.next != null){
            curr.next = curr.next.next;
        }else System.out.println("Position Not Found");

        return head;
    }
    private static ListNode addAtStart(ListNode node){
        node.next = head;
        head = node;
        return head;
    }
    private static ListNode addAtEnd(ListNode node){
        if(head == null) return null;

        ListNode curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = node;

        return head;

    }
}
