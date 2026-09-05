package LinkedList.ProblemSet.Basics;

import LinkedList.ListNode;

public class SinglyLinkedList {
    int val;
    SinglyLinkedList next;
    static SinglyLinkedList head;

    SinglyLinkedList(){

    }

    SinglyLinkedList(int val){
        this.val = val;
    }

    SinglyLinkedList(int val, SinglyLinkedList next){
        this.val = val;
        this.next = next;
    }

    private static void Traversal(SinglyLinkedList head){
        SinglyLinkedList curr = head;

        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");

    }
    private static SinglyLinkedList InsertAtstart(SinglyLinkedList node){
        node.next = head;
        head = node;
        return head;
    }
    private static SinglyLinkedList InsertAtEnd(SinglyLinkedList node){
        if(head == null){
            head = node;
            return head;
        }

        SinglyLinkedList curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        curr.next = node;
        return head;
    }
    private static SinglyLinkedList InsertAtPosition(SinglyLinkedList node, int position){
        SinglyLinkedList curr = head;
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
    private static SinglyLinkedList DeleteAtStart(){
        if(head == null || head.next == null) return null;
        head = head.next;
        return head;
    }

    public static void main(String[] args){
        SinglyLinkedList one = new SinglyLinkedList(1);
        SinglyLinkedList two = new SinglyLinkedList(2);
        SinglyLinkedList three = new SinglyLinkedList(3);
        SinglyLinkedList four = new SinglyLinkedList(4);

        one.next = two;
        two.next = three;
        three.next = four;

        head = one;

        System.out.println("Printing the Singly Linked List");
        Traversal(head);

        SinglyLinkedList zero = new SinglyLinkedList(0);
        System.out.println("Inseting node 0 at start");
        InsertAtstart(zero);
        Traversal(head);

        SinglyLinkedList five = new SinglyLinkedList(5);
        System.out.println("Inserting node 5 at the end");
        InsertAtEnd(five);
        Traversal(head);

        SinglyLinkedList six = new SinglyLinkedList(6);
        System.out.println("Inserting node 6 at position 2");
        InsertAtPosition(six,2);
        Traversal(head);

        System.out.println("Deleting at Start");
        DeleteAtStart();
        Traversal(head);
    }
}
