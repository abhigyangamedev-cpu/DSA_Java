package LinkedList;

public class ListNode {

    public int val;
    public ListNode next;
    public static ListNode head;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static class ListNodeMethods {

        public static void printList(ListNode head) {
            ListNode curr = head;

            while (curr != null) {
                System.out.print(curr.val + "->");
                curr = curr.next;
            }

            System.out.println("null");
        }
        private static ListNode InsertAtEnd(ListNode node) {

            if (ListNode.head == null) {
                ListNode.head = node;
                return ListNode.head;
            }

            ListNode curr = ListNode.head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;

            return ListNode.head;
        }
        private static ListNode InsertAtStart(ListNode node) {

            if (ListNode.head == null) {
                ListNode.head = node;
                return ListNode.head;
            }

            node.next = ListNode.head;
            ListNode.head = node;

            return ListNode.head;
        }
        private static ListNode InsertAtPosition(ListNode node, int position) {

            if (position < 1) {
                System.out.println("Invalid Position");
                return ListNode.head;
            }

            if (position == 1) {
                node.next = ListNode.head;
                ListNode.head = node;
                return ListNode.head;
            }

            ListNode curr = ListNode.head;
            int counter = 1;

            while (curr != null && counter < position - 1) {
                curr = curr.next;
                counter++;
            }

            if (curr != null) {
                node.next = curr.next;
                curr.next = node;
            } else {
                System.out.println("Invalid Position");
            }

            return ListNode.head;
        }
        private static ListNode InsertAtIndex(ListNode node, int index) {

            if (index < 0) {
                System.out.println("Invalid Index");
                return ListNode.head;
            }

            if (index == 0) {
                node.next = ListNode.head;
                ListNode.head = node;
                return ListNode.head;
            }

            ListNode curr = ListNode.head;
            int counter = 0;

            while (curr != null && counter < index - 1) {
                curr = curr.next;
                counter++;
            }

            if (curr != null) {
                node.next = curr.next;
                curr.next = node;
            } else {
                System.out.println("Invalid Index");
            }

            return ListNode.head;
        }
        private static ListNode InsertAfterValue(ListNode node, int value) {

            ListNode curr = ListNode.head;

            while (curr != null && curr.val != value) {
                curr = curr.next;
            }

            if (curr != null) {
                node.next = curr.next;
                curr.next = node;
            } else {
                System.out.println("Invalid Value");
            }

            return ListNode.head;
        }
        private static ListNode deleteAtEnd(ListNode head) {

            if (head == null || head.next == null) {
                return null;
            }

            ListNode curr = head;

            while (curr.next.next != null) {
                curr = curr.next;
            }

            curr.next = null;

            return head;
        }
        private static ListNode deleteAtStart(ListNode head) {

            if (head == null) {
                return null;
            }

            return head.next;
        }
        private static ListNode deleteAtPosition(int position) {

            if (position < 1) {
                System.out.println("Invalid Position");
                return ListNode.head;
            }

            if (ListNode.head == null) {
                System.out.println("Invalid Position");
                return null;
            }

            if (position == 1) {
                return ListNode.head.next;
            }

            int counter = 1;
            ListNode curr = ListNode.head;

            while (curr != null && counter < position - 1) {
                curr = curr.next;
                counter++;
            }

            if (curr != null && curr.next != null) {
                curr.next = curr.next.next;
            } else {
                System.out.println("Invalid Position");
            }

            return ListNode.head;
        }
        private static ListNode deleteAtIndex(int index) {

            if (index < 0) {
                System.out.println("Invalid Index");
                return ListNode.head;
            }

            if (ListNode.head == null) {
                System.out.println("Invalid Index");
                return null;
            }

            if (index == 0) {
                return ListNode.head.next;
            }

            int counter = 0;
            ListNode curr = ListNode.head;

            while (curr != null && counter < index - 1) {
                curr = curr.next;
                counter++;
            }

            if (curr != null && curr.next != null) {
                curr.next = curr.next.next;
            } else {
                System.out.println("Invalid Index");
            }

            return ListNode.head;
        }
        private static ListNode deleteAfterValue(int value) {

            ListNode curr = ListNode.head;

            while (curr != null && curr.val != value) {
                curr = curr.next;
            }

            if (curr != null && curr.next != null) {
                curr.next = curr.next.next;
            } else {
                System.out.println("Invalid Value or No Node After Value");
            }

            return ListNode.head;
        }
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode.head = one;

        System.out.println("Initial Linked List:");
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n========== INSERTION OPERATIONS ==========");

        System.out.println("\n1. Insert 6 at End:");
        ListNodeMethods.InsertAtEnd(new ListNode(6));
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n2. Insert 0 at Start:");
        ListNodeMethods.InsertAtStart(new ListNode(0));
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n3. Insert 7 at Position 3:");
        ListNodeMethods.InsertAtPosition(new ListNode(7), 3);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n4. Insert 8 at Index 5:");
        ListNodeMethods.InsertAtIndex(new ListNode(8), 5);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n5. Insert 9 after Value 4:");
        ListNodeMethods.InsertAfterValue(new ListNode(9), 4);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n========== DELETION OPERATIONS ==========");

        System.out.println("\n1. Delete from End:");
        ListNode.head = ListNodeMethods.deleteAtEnd(ListNode.head);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n2. Delete from Start:");
        ListNode.head = ListNodeMethods.deleteAtStart(ListNode.head);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n3. Delete at Position 2:");
        ListNode.head = ListNodeMethods.deleteAtPosition(2);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n4. Delete at Index 3:");
        ListNode.head = ListNodeMethods.deleteAtIndex(3);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n5. Delete node after Value 3:");
        ListNode.head = ListNodeMethods.deleteAfterValue(3);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("\n========== FINAL LINKED LIST ==========");
        ListNodeMethods.printList(ListNode.head);
    }
}