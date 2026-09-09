package QuestionPapers.QuestionPaper;

public class Q1 {

    static class ListNode {
        int val;
        ListNode next;
        public static ListNode head;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class ListNodeMethods{
        private static void printList(ListNode head){
            ListNode curr = head;

            while (curr != null){
                System.out.print(curr.val + "->");
                curr = curr.next;
            }
            System.out.println("null");
        }
        private static ListNode InsertAtEnd(ListNode node){
            if(ListNode.head == null) {
                ListNode.head = node;
                return ListNode.head;
            }

            ListNode curr = ListNode.head;

            while (curr.next != null){
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
        private static ListNode InsertAfterValue(ListNode node, int value){
            ListNode curr = ListNode.head;
            while (curr != null && curr.val != value){
                curr = curr.next;
            }

            if(curr != null){
                node.next = curr.next;
                curr.next = node;
            }else{
                System.out.println("Invalid value");
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

        ListNode six = new ListNode(6);
        ListNodeMethods.printList(ListNode.head);

        ListNodeMethods.InsertAtEnd(six);
        ListNodeMethods.printList(ListNode.head);

        ListNode zero = new ListNode(0);
        ListNodeMethods.InsertAtStart(zero);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("Inserting Node 7 at 3rd postion");
        ListNode seven = new ListNode(7);
        ListNodeMethods.InsertAtPosition(seven,3);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("Inserting Node 8 at 5th index");
        ListNode eight = new ListNode(8);
        ListNodeMethods.InsertAtIndex(eight,5);
        ListNodeMethods.printList(ListNode.head);

        System.out.println("Inserting Node 9 after 4");
        ListNode nine = new ListNode(9);
        ListNodeMethods.InsertAfterValue(nine,4);
        ListNodeMethods.printList(ListNode.head);



    }
}