package LinkedList.ProblemSet.Basics;

public class DoublyCircularLinkedList {

    int val;
    DoublyCircularLinkedList next;
    DoublyCircularLinkedList prev;
    static DoublyCircularLinkedList head;

    DoublyCircularLinkedList() {}

    DoublyCircularLinkedList(int val) {
        this.val = val;
    }

    DoublyCircularLinkedList(int val,
                             DoublyCircularLinkedList next,
                             DoublyCircularLinkedList prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public static void printList(DoublyCircularLinkedList head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        DoublyCircularLinkedList curr = head;

        while (true) {
            System.out.print(curr.val + "⇄");
            curr = curr.next;

            if (curr == head) {
                break;
            }
        }

        System.out.println("(back to HEAD)");
    }

    private static void printListBackward(DoublyCircularLinkedList head) {

        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        DoublyCircularLinkedList curr = head.prev;

        while (true) {
            System.out.print(curr.val + "⇄");
            curr = curr.prev;

            if (curr == head.prev) {
                break;
            }
        }

        System.out.println("(back to TAIL)");
    }

    private static DoublyCircularLinkedList insertAtStart(
            DoublyCircularLinkedList head, int key) {

        DoublyCircularLinkedList newNode =
                new DoublyCircularLinkedList(key);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }

        DoublyCircularLinkedList tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;

        tail.next = newNode;
        head.prev = newNode;

        return newNode;
    }

    private static DoublyCircularLinkedList insertAtEnd(
            DoublyCircularLinkedList head, int key) {

        DoublyCircularLinkedList newNode =
                new DoublyCircularLinkedList(key);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }

        DoublyCircularLinkedList tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;

        tail.next = newNode;
        head.prev = newNode;

        return head;
    }

    private static DoublyCircularLinkedList insertAtPosition(
            DoublyCircularLinkedList head,
            int key,
            int position) {

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

        DoublyCircularLinkedList curr = head;

        for (int i = 0; i < position - 1; i++) {

            curr = curr.next;

            if (curr == head) {
                System.out.println("Position out of bounds");
                return head;
            }
        }

        DoublyCircularLinkedList newNode =
                new DoublyCircularLinkedList(key);

        newNode.next = curr.next;
        newNode.prev = curr;

        curr.next.prev = newNode;
        curr.next = newNode;

        return head;
    }

    private static DoublyCircularLinkedList deleteAtStart(
            DoublyCircularLinkedList head) {

        if (head == null) {
            System.out.println("Empty List");
            return null;
        }

        if (head.next == head) {
            return null;
        }

        DoublyCircularLinkedList tail = head.prev;
        DoublyCircularLinkedList newHead = head.next;

        tail.next = newHead;
        newHead.prev = tail;

        return newHead;
    }

    private static DoublyCircularLinkedList deleteAtEnd(
            DoublyCircularLinkedList head) {

        if (head == null) {
            System.out.println("Empty List");
            return null;
        }

        if (head.next == head) {
            return null;
        }

        DoublyCircularLinkedList tail = head.prev;
        DoublyCircularLinkedList newTail = tail.prev;

        newTail.next = head;
        head.prev = newTail;

        return head;
    }

    private static DoublyCircularLinkedList deleteAtPosition(
            DoublyCircularLinkedList head,
            int position) {

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

        DoublyCircularLinkedList curr = head;

        for (int i = 0; i < position; i++) {

            curr = curr.next;

            if (curr == head) {
                System.out.println("Position out of bounds");
                return head;
            }
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        return head;
    }

    private static boolean search(
            DoublyCircularLinkedList head,
            int key) {

        if (head == null) {
            return false;
        }

        DoublyCircularLinkedList curr = head;

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
            DoublyCircularLinkedList head,
            int oldValue,
            int newValue) {

        if (head == null) {
            return false;
        }

        DoublyCircularLinkedList curr = head;

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

    private static DoublyCircularLinkedList reverse(
            DoublyCircularLinkedList head) {

        if (head == null || head.next == head) {
            return head;
        }

        DoublyCircularLinkedList curr = head;

        while (true) {

            DoublyCircularLinkedList temp = curr.next;

            curr.next = curr.prev;
            curr.prev = temp;

            curr = temp;

            if (curr == head) {
                break;
            }
        }

        return head.prev;
    }

    public static void main(String[] args) {

        DoublyCircularLinkedList one =
                new DoublyCircularLinkedList(1);

        DoublyCircularLinkedList two =
                new DoublyCircularLinkedList(2);

        DoublyCircularLinkedList three =
                new DoublyCircularLinkedList(3);

        DoublyCircularLinkedList four =
                new DoublyCircularLinkedList(4);

        one.next = two;
        two.prev = one;

        two.next = three;
        three.prev = two;

        three.next = four;
        four.prev = three;

        four.next = one;
        one.prev = four;

        head = one;

        System.out.println("Original Doubly Circular List");
        printList(head);

        System.out.println("\nBackward Traversal");
        printListBackward(head);

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

        System.out.println("\nReversing Doubly Circular List");
        head = reverse(head);
        printList(head);

        System.out.println("\nBackward Traversal After Reverse");
        printListBackward(head);
    }
}