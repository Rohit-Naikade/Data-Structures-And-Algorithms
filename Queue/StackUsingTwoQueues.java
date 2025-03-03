import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingTwoQueues {

    static Queue<Integer> queue1;
    static Queue<Integer> queue2;

    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public static void push(int x) {
        queue1.add(x);
    }

    public static int pop() {

        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }

        int num = queue1.poll();

        Queue<Integer> tmp=queue1;
        queue1=queue2;
        queue2=tmp;

        return num;
    }

    public static int top() {

        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }

        int num = queue1.peek();
        queue2.add(queue1.poll());

        Queue<Integer> tmp=queue1;
        queue1=queue2;
        queue2=tmp;

        return num;
    }

    public static boolean empty() {
        return queue1.isEmpty();
    }

    public static void print(){

        while(queue1.size()>0){
            queue2.add(queue1.poll());
        }

        Queue<Integer> tmp=queue1;
        queue1=queue2;
        queue2=tmp;

        System.out.println("Queue Elements:");
        for(Integer num: queue1){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
         StackUsingTwoQueues queue=new StackUsingTwoQueues();
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
