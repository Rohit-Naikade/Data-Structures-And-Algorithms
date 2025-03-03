import java.util.Scanner;

public class QueueImplementation {

    public static int front, rear, size;
    public static int queue[];

    public QueueImplementation(int size) {
        queue = new int[size];
        this.size = size;
        front = 0;
        rear = 0;
    }

    private static void enqueue(int num) {
        if (front == size) {
            System.out.println("Queue is full!!");
            return;
        }

        queue[front] = num;
        front++;
    }

    private static void dequeue() {
        if (rear == front) {
            System.out.println("Queue is empty!!");
            return;
        }

        System.out.println("Element removed: " + queue[rear]);
        for (int i = 0; i < front - 1; i++) {
            queue[i] = queue[i + 1];
        }

        front--;

    }

    private static void printQueue() {
        System.out.print("Queue Elements:");

        for (int i = 0; i < front; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    private static void size() {
        System.out.println("Size of Queue: " + front);
    }

    private void returnFront() {
        System.out.println("Fornt Element: " + queue[front]);
    }

    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation(20);

        Scanner sc = new Scanner(System.in);
        int choice = 0, num = 0;

        while (choice != 6) {
            System.out.println("***************** Menu *****************");
            System.out.println("1. Add element:");
            System.out.println("2. Delete element:");
            System.out.println("3. Print Queue:");
            System.out.println("4. Size of the Queue:");
            System.out.println("5. Front of Queue:");
            System.out.println("6. Exit:");
            System.out.println("7. Enter your Choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    queue.enqueue(num);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.printQueue();
                    break;
                case 4:
                    queue.size();
                    break;
                case 5:
                    queue.returnFront();
                    break;
                case 6:
                    break;
            }
        }
    }

}