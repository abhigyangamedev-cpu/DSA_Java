package Queues;

import LinkedList.ListNode;

public class Queue {

    static ListNode front , rear;

    private static void enqueue(int val){
        ListNode newNode = new ListNode(val);

        if(rear == null){
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    private static int dequeue(){
        if(front == null) return -1;

        int data = front.val;
        front = front.next;

        if(front == null){
            rear = null;
        }

        return data;
    }

    private static int peak(){
        if(front == null) return -1;
        return front.val;
    }


    private static boolean isEmpty(){
        if(front == null) return true;
        return false;
    }

    public static void display(){
        ListNode curr = front;

        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Queue q = new Queue();
        System.out.println("Is queue empty? " + q.isEmpty());

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println("\nQueue after enqueue:");

        q.display();

        System.out.println("\nFront element (peek): " + q.peak());
        System.out.println("\nDequeued: " + q.dequeue());
        System.out.println("Queue after dequeue:");

        q.display();

        System.out.println("Is queue empty? " + q.isEmpty());

    }


}
