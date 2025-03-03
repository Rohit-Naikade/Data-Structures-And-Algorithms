import java.util.Scanner;

class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class SinglyLinkedList {

    private static Node addAtEnd(Node head, int num) {

        if (head == null) {
            head = new Node(num);
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(num);

        System.out.println("Node added successfully!");
        return head;
    }

    private static Node deleteAtEnd(Node head, int num) {

        if (head == null) {
            return head;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        System.out.println("Node deleted successfully!");
        return head;
    }

    private static Node addAtBeginning(Node head, int num) {

        if (head == null) {
            head = new Node(num);
            return head;
        }

        Node temp = new Node(num);
        temp.next = head;
        head = temp;

        System.out.println("Node added successfully!");
        return head;
    }

    private static Node deleteAtBeginning(Node head, int num) {

        head=head.next;
        System.out.println("Node deleted successfully!");
        return head;
    }

    private static Node addAtSpecificPosition(Node head, int num, int pos) {

        if (head == null) {
            head = new Node(num);
            return head;
        }

        if (pos > length(head)) {
            System.out.println("Invalid Position!!");
            return head;
        }

        Node temp = head;
        while (pos != 2) {
            temp = temp.next;
            pos--;
        }

        Node newNode = new Node(num);

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Node added successfully!");
        return head;
    }

    private static Node deleteAtSpecificPosition(Node head, int pos) {

        if (head == null) {
            return head;
        }

        if (pos > length(head)) {
            System.out.println("Invalid Position!!");
            return head;
        }

        Node temp = head;
        while (pos != 2) {
            temp = temp.next;
            pos--;
        }

        temp.next = temp.next.next;

        System.out.println("Node deleted successfully!");
        return head;
    }

    private static void print(Node head) {
        System.out.println("Linked List Elements: ");

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    private static int length(Node head) {

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    private static boolean search(Node head, int num) {

        Node temp=head;
        while (temp != null) {
            if(temp.value==num){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;
        int choice = 0, num = 0;

        while (choice != 10) {
            System.out.println();
            System.out.println("***************** Menu *****************");
            System.out.println("1. Add Node at the end:");
            System.out.println("2. Add Node at the beginning:");
            System.out.println("3. Add Node at any specific position:");
            System.out.println("4. Print Linked List:");
            System.out.println("5. Size of the linked list:");
            System.out.println("6. Search an element:");
            System.out.println("7. Delete Node at the end:");
            System.out.println("8. Delete Node at the beginning:");
            System.out.println("9. Delete Node at any specific position:");
            System.out.println("10. Exit:");
            System.out.println("Enter your Choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    head = addAtEnd(head, num);
                    break;
                case 2:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    head = addAtBeginning(head, num);
                    break;
                case 3:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    System.out.println("Enter position:");
                    int loc = sc.nextInt();
                    head = addAtSpecificPosition(head, num, loc);
                case 4:
                    print(head);
                    break;
                case 5:
                    System.out.println("Enter Element you want to search:");
                    num = sc.nextInt();
                    System.out.println("Is element present? :" + search(head, num));
                    break;
                case 6:
                    System.out.println("Length of a linked list is: " + length(head));
                    break;
                case 7:
                    head = deleteAtEnd(head, num);
                    break;
                case 8:
                    head = deleteAtBeginning(head, num);
                    break;
                case 9:
                    System.out.println("Enter position:");
                    loc = sc.nextInt();
                    head = deleteAtSpecificPosition(head, loc);
                case 10:
                    break;
            }
        }

    }

}
