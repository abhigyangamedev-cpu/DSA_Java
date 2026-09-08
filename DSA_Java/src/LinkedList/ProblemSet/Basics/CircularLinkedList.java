package LinkedList.ProblemSet.Basics;

public class CircularLinkedList {

    int val;
    CircularLinkedList next;
    static CircularLinkedList head;

    CircularLinkedList() {}

    CircularLinkedList(int val) {
        this.val = val;
    }

    CircularLinkedList(int val, CircularLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(CircularLinkedList head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        CircularLinkedList curr = head;

        while (true) {
            System.out.print(curr.val + "->");
            curr = curr.next;

            if (curr == head) {
                break;
            }
        }

        System.out.println("(back to HEAD)");
    }

    private static CircularLinkedList insertAtStart(
            CircularLinkedList head, int key) {

        CircularLinkedList newNode =
                new CircularLinkedList(key);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        CircularLinkedList curr = head;

        while (curr.next != head) {
            curr = curr.next;
        }

        newNode.next = head;
        curr.next = newNode;

        return newNode;
    }

    private static CircularLinkedList insertAtEnd(
            CircularLinkedList head, int key) {

        CircularLinkedList newNode =
                new CircularLinkedList(key);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        CircularLinkedList curr = head;

        while (curr.next != head) {
            curr = curr.next;
        }

        newNode.next = head;
        curr.next = newNode;

        return head;
    }

    private static CircularLinkedList insertAtPosition(
            CircularLinkedList head, int key, int position) {

        if (position < 0) {
            System.out.println("Invalid Position");
            return head;
        }

        if (position == 0) {
            return insertAtStart(head, key);
        }

        if (head == null) {
            System.out.println("Invalid Position");
            return head;
        }

        CircularLinkedList newNode =
                new CircularLinkedList(key);

        CircularLinkedList curr = head;

        for (int i = 0; i < position - 1; i++) {

            curr = curr.next;

            if (curr == head) {
                System.out.println("Position out of bounds");
                return head;
            }
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    private static CircularLinkedList deleteAtStart(
            CircularLinkedList head) {

        if (head == null) {
            System.out.println("Empty List");
            return null;
        }

        if (head.next == head) {
            return null;
        }

        CircularLinkedList curr = head;

        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = head.next;
        head = head.next;

        return head;
    }

    private static CircularLinkedList deleteAtEnd(
            CircularLinkedList head) {

        if (head == null) {
            System.out.println("Empty List");
            return null;
        }

        if (head.next == head) {
            return null;
        }

        CircularLinkedList curr = head;

        while (curr.next.next != head) {
            curr = curr.next;
        }

        curr.next = head;

        return head;
    }

    private static CircularLinkedList deleteAtPosition(
            CircularLinkedList head, int position) {

        if (head == null) {
            System.out.println("Empty List");
            return null;
        }

        if (position < 0) {
            System.out.println("Invalid Position");
            return head;
        }

        if (position == 0) {
            return deleteAtStart(head);
        }

        CircularLinkedList curr = head;

        for (int i = 0; i < position - 1; i++) {

            curr = curr.next;

            if (curr == head) {
                System.out.println("Position out of bounds");
                return head;
            }
        }

        if (curr.next == head) {
            System.out.println("Position out of bounds");
            return head;
        }

        curr.next = curr.next.next;

        return head;
    }

    private static boolean search(
            CircularLinkedList head, int key) {

        if (head == null) {
            return false;
        }

        CircularLinkedList curr = head;

        while (true) {

            if (curr.val == key) {
                return true;
            }

            curr = curr.next;

            if (curr == head) {
                break;
            }
        }

        return false;
    }

    private static boolean update(
            CircularLinkedList head,
            int oldValue,
            int newValue) {

        if (head == null) {
            return false;
        }

        CircularLinkedList curr = head;

        while (true) {

            if (curr.val == oldValue) {
                curr.val = newValue;
                return true;
            }

            curr = curr.next;

            if (curr == head) {
                break;
            }
        }

        return false;
    }

    private static CircularLinkedList reverse(
            CircularLinkedList head) {

        if (head == null || head.next == head) {
            return head;
        }

        CircularLinkedList prev = null;
        CircularLinkedList curr = head;
        CircularLinkedList next;

        while (curr != head || prev == null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            if (curr == head) {
                break;
            }
        }

        head.next = prev;

        return prev;
    }

    public static void main(String[] args) {

        CircularLinkedList one =
                new CircularLinkedList(1);

        CircularLinkedList two =
                new CircularLinkedList(2);

        CircularLinkedList three =
                new CircularLinkedList(3);

        CircularLinkedList four =
                new CircularLinkedList(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = one;

        head = one;

        System.out.println("Original Circular List");
        printList(head);

        System.out.println("\nInsert 0 at beginning");
        head = insertAtStart(head, 0);
        printList(head);

        System.out.println("\nInsert 6 at end");
        head = insertAtEnd(head, 6);
        printList(head);

        System.out.println("\nInsert 35 at position 4");
        head = insertAtPosition(head, 35, 4);
        printList(head);

        System.out.println("\nSearching for 3");

        if (search(head, 3)) {
            System.out.println("Key Found");
        } else {
            System.out.println("Key Not Found");
        }

        System.out.println("\nUpdating 35 -> 5");
        update(head, 35, 5);
        printList(head);

        System.out.println("\nDelete from beginning");
        head = deleteAtStart(head);
        printList(head);

        System.out.println("\nDelete from end");
        head = deleteAtEnd(head);
        printList(head);

        System.out.println("\nDelete position 2");
        head = deleteAtPosition(head, 2);
        printList(head);

        System.out.println("\nReversing Circular List");
        head = reverse(head);
        printList(head);
    }
}

