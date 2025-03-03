import java.util.*;

public class StackUsingOneQueue {

    static Queue<Integer> queue;

    public StackUsingOneQueue() {
        queue = new LinkedList<>();
    }

    public static void push(int x) {
        int size = queue.size();
        queue.add(x);
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
            print();
        }
        print();
    }

    public static int pop() {
        int num = queue.poll();
        return num;
    }

    public static int top() {
        return queue.peek();
    }

    public static boolean empty() {
        return queue.isEmpty();
    }

    public static void print(){

        System.out.println("Queue Elements:");
        for(Integer num: queue){
            System.out.print(num+" ");
        }
    }
    public static void main(String[] args) {

        StackUsingOneQueue queue=new StackUsingOneQueue();
        Scanner sc = new Scanner(System.in);
        int choice = 0, num = 0;

        while (choice != 6) {
            System.out.println("***************** Menu *****************");
            System.out.println("1. Add element:");
            System.out.println("2. Delete element:");
            System.out.println("3. is stack empty?:");
            System.out.println("4. top of Stack:");
            System.out.println("5. print stack:");
            System.out.println("6. Exit:");
            System.out.println("Enter your Choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Element:");
                    num = sc.nextInt();
                    push(num);
                    break;
                case 2:
                    System.out.println("Removed element: " + pop());
                    break;
                case 3:
                    System.out.println("Is stack empty? " + empty());
                    break;
                case 4:
                    System.out.println("Top of stack: "+top());
                    break;
                case 5:
                    print();
                    break;
                case 6:
                    break;
            }
        }

    }
}
