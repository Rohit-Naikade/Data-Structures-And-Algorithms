import java.util.Scanner;

class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next=null;
    }
}

public class CircularSinglyLinkedList {

    private static Node addAtEnd(Node tail, int num) {

        if (tail == null) {
            tail = new Node(num);
            tail.next=tail;
            return tail;
        }

        Node newNode = new Node(num);
       
        newNode.next=tail.next;
        tail.next=newNode;

        System.out.println("Node added successfully!");
        return newNode;
    }

    private static Node deleteAtEnd(Node tail, int num) {

        if (tail == null) {
            return tail;
        }

        Node head = tail.next;
        while (head.next!=tail) {
            head = head.next;
        }

        head.next = tail.next;

        System.out.println("Node deleted successfully!");
        return head;
    }

    private static Node addAtBeginning(Node tail, int num) {

        if (tail == null) {
            tail = new Node(num);
            tail.next=tail;
            return tail;
        }

        Node newNode = new Node(num);
        newNode.next=tail.next;
        tail.next=newNode;

        System.out.println("Node added successfully!");
        return tail;
    }

    private static Node deleteAtBeginning(Node tail, int num) {

        tail.next=tail.next.next;
        System.out.println("Node deleted successfully!");
        return tail;
    }

    private static Node addAtSpecificPosition(Node tail, int num, int pos) {

        if (tail == null) {
            tail = new Node(num);
            tail.next=tail;
            return tail;
        }

        if (pos > length(tail)) {
            System.out.println("Invalid Position!!");
            return tail;
        }

        Node temp = tail.next;
        while (pos != 2) {
            temp = temp.next;
            pos--;
        }

        Node newNode = new Node(num);

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Node added successfully!");
        return tail;
    }

    private static Node deleteAtSpecificPosition(Node tail, int pos) {

        if (tail == null) {
            return tail;
        }

        if (pos > length(tail)) {
            System.out.println("Invalid Position!!");
            return tail;
        }

        Node temp = tail.next;
        while (pos != 2) {
            temp = temp.next;
            pos--;
        }

        temp.next = temp.next.next;

        System.out.println("Node deleted successfully!");
        return tail;
    }

    private static void print(Node tail) {
        System.out.println("Linked List Elements: ");

        Node temp = tail.next;
        while (true) {
            System.out.print(temp.value + " ");
            temp = temp.next;

            if(temp==tail.next){
                break;
            }
        }
    }

    private static int length(Node tail) {

        int count = 0;
        Node head=tail.next;
        while (true) {
            count++;
            head = head.next;
            if(head==tail.next){
                break;
            }
        }

        return count;
    }

    private static boolean search(Node tail, int num) {

        Node head=tail.next;
        while (true) {

            head = head.next;
            if(head.value==num){
                return true;
            }
            if(head==tail.next){
                break;
            }
        }


        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Node tail = null;
        int choice = 0, num = 0;

        while (choice != 11) {
            System.out.println();
            System.out.println("***************** Menu *****************");
            System.out.println("1. Add Node at the end:");
            System.out.println("2. Add Node at the beginning:");
            System.out.println("3. Add Node at any specific position:");
            System.out.println("4. Print Linked List:");
            System.out.println("5. Print Linked List in reverse:");
            System.out.println("6. Search an element:");
            System.out.println("7. Size of the linked list:");
            System.out.println("8. Delete Node at the end:");
            System.out.println("9. Delete Node at the beginning:");
            System.out.println("10. Delete Node at any specific position:");
            System.out.println("11. Exit:");
            System.out.println("Enter your Choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    tail = addAtEnd(tail, num);
                    break;
                case 2:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    tail = addAtBeginning(tail, num);
                    break;
                case 3:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    System.out.println("Enter position:");
                    int loc = sc.nextInt();
                    tail = addAtSpecificPosition(tail, num, loc);
                case 4:
                    print(tail);
                    break;
                case 5:
                    //printInReverse(tail);
                    break;
                case 6:
                    System.out.println("Enter Element you want to search:");
                    num = sc.nextInt();
                    System.out.println("Is element present? :" + search(tail, num));
                    break;
                case 7:
                    System.out.println("Length of a linked list is: " + length(tail));
                    break;
                case 8:
                    tail = deleteAtEnd(tail, num);
                    break;
                case 9:
                    tail = deleteAtBeginning(tail, num);
                    break;
                case 10:
                    System.out.println("Enter position:");
                    loc = sc.nextInt();
                    tail = deleteAtSpecificPosition(tail, loc);
                case 11:
                    break;
            }
        }
    }
}
