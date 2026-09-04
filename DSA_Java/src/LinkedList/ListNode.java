package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public static ListNode head;

    // Default Constructor
    ListNode(){

    }

    // Constructor with value
    ListNode(int val){
        this.val = val;
    }

    // Constructor with value and Node
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
        System.out.print("null");
    }

    public static void main(String[] args){
        // Printing Linked List 1->2->3->null
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        head = one;

        printList(head);

    }
}
