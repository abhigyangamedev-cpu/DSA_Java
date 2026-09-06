package LinkedList.ProblemSet.Basics;

import javax.xml.crypto.dom.DOMCryptoContext;

public class DoublyLinkedList {
    int val;
    DoublyLinkedList next;
    DoublyLinkedList prev;
    static DoublyLinkedList head;

    DoublyLinkedList(){

    }

    DoublyLinkedList(int val){
        this.val = val;
    }

    DoublyLinkedList(int val, DoublyLinkedList next, DoublyLinkedList prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    private static void TraversalForward(DoublyLinkedList head){
        DoublyLinkedList curr = head;

        while (curr != null){
            System.out.print(curr.val + "⇄");
            curr = curr.next;
        }
        System.out.println("null");
    }
    private static void TraversalBackward(DoublyLinkedList head) {
        if (head == null) {
            System.out.println("null");
            return;
        }

        DoublyLinkedList curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        while (curr != null) {
            System.out.print(curr.val + "⇄");
            curr = curr.prev;
        }

        System.out.println("null");
    }
    private static DoublyLinkedList InsertAtStart(DoublyLinkedList node) {
        node.next = head;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        return head;
    }
    private static DoublyLinkedList InsertAtEnd(DoublyLinkedList node) {
        if (head == null) {
            head = node;
            return head;
        }

        DoublyLinkedList curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = node;
        node.prev = curr;

        return head;
    }
    private static DoublyLinkedList InsertAtPosition(DoublyLinkedList node, int position) {
        if (position < 1) {
            System.out.println("Position Not Found");
            return head;
        }

        if (position == 1) {
            node.next = head;

            if (head != null) {
                head.prev = node;
            }

            head = node;
            return head;
        }

        DoublyLinkedList curr = head;
        int counter = 1;

        while (curr != null && counter < position - 1) {
            curr = curr.next;
            counter++;
        }

        if (curr != null) {
            node.next = curr.next;
            node.prev = curr;

            if (curr.next != null) {
                curr.next.prev = node;
            }

            curr.next = node;
        } else {
            System.out.println("Position Not Found");
        }

        return head;
    }
    private static DoublyLinkedList DeleteAtStart() {
        if (head == null) return null;

        head = head.next;

        if (head != null) {
            head.prev = null;
        }

        return head;
    }
    private static DoublyLinkedList DeleteAtEnd() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            head = null;
            return head;
        }

        DoublyLinkedList curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;

        return head;
    }
    private static DoublyLinkedList DeleteAtPosition(int position) {
        if (head == null) return null;

        if (position < 1) {
            System.out.println("Position Not Found");
            return head;
        }

        if (position == 1) {
            head = head.next;

            if (head != null) {
                head.prev = null;
            }

            return head;
        }

        DoublyLinkedList curr = head;
        int counter = 1;

        while (curr != null && counter < position - 1) {
            curr = curr.next;
            counter++;
        }

        if (curr != null && curr.next != null) {
            curr.next.next.prev = curr;
            curr.next = curr.next.next;
        } else {
            System.out.println("Position Not Found");
        }

        return head;
    }
    private static boolean CheckIfPresent(int value){
        DoublyLinkedList curr = head;

        while (curr != null){
            if(curr.val == value){
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
    private static DoublyLinkedList UpdateElement(int oldValue , int newValue){
        DoublyLinkedList curr = head;

        while (curr != null){
            if(curr.val == oldValue){
                curr.val = newValue;
                break;
            }

            curr = curr.next;
        }

        return head;
    }
    private static DoublyLinkedList ReverseList(DoublyLinkedList head) {
        DoublyLinkedList curr = head;
        DoublyLinkedList newHead = null;

        while (curr != null) {
            DoublyLinkedList temp = curr.next;

            curr.next = curr.prev;
            curr.prev = temp;

            newHead = curr;
            curr = temp;
        }

        return newHead;
    }


    public static void main(String[] args){
        DoublyLinkedList one = new DoublyLinkedList(1);
        DoublyLinkedList two = new DoublyLinkedList(2);
        DoublyLinkedList three = new DoublyLinkedList(3);
        DoublyLinkedList four = new DoublyLinkedList(4);

        one.next = two;
        two.prev = one;

        two.next = three;
        three.prev = two;

        three.next = four;
        four.prev = three;

        head = one;

        System.out.println("Printing the Doubly Linked while traversing forward");
        TraversalForward(head);

        System.out.println("Printing the Doubly Linked while traversing backward");
        TraversalBackward(head);

        DoublyLinkedList zero = new DoublyLinkedList(0);

        System.out.println("Adding node 0 at the start");
        InsertAtStart(zero);
        TraversalForward(head);

        DoublyLinkedList five = new DoublyLinkedList(5);

        System.out.println("Adding node 5 at the end");
        InsertAtEnd(five);
        TraversalForward(head);

        DoublyLinkedList six = new DoublyLinkedList(6);

        System.out.println("Inserting at node 6 at position 2");
        InsertAtPosition(six,2);
        TraversalForward(head);

        System.out.println("Deleting at the start");
        DeleteAtStart();
        TraversalForward(head);

        System.out.println("Deleting at the end");
        DeleteAtEnd();
        TraversalForward(head);

        System.out.println("Deleting at position 2");
        DeleteAtPosition(2);
        TraversalForward(head);

        System.out.println("Checking if 6 is present or not :- "+CheckIfPresent(6));

        System.out.println("Checking if 5 is present or :- " + CheckIfPresent(5));

        System.out.println("Updating node 3 value with 5");
        UpdateElement(3,5);
        TraversalForward(head);

        System.out.println("Reversing the List");
        head = ReverseList(head);
        TraversalForward(head);

    }
}
