import java.util.*;
import java.util.Stack;

public class QueueUsingStackEnqueue{

    public static Stack<Integer> stack1;
    public static Stack<Integer> stack2;

    QueueUsingStackEnqueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    } 

    public static void push(int x) {

       while(stack1.size()>0){
           stack2.push(stack1.pop());
       }

       stack2.push(x);

       while(stack2.size()>0){
        stack1.push(stack2.pop());
        }
    }

    public static int pop() {

        int num = stack1.pop();
        return num;
    }

    public static int top() {

        return stack1.peek();
    }

    public static boolean empty() {
        return stack1.empty();
    }

    public static void print(){

        while(stack1.size()>0){
            stack2.push(stack1.pop());
        }

        System.out.println("Queue Elements:");
        for(Integer num: stack2){
            System.out.print(num+" ");
        }
    }

    public static void main(String args[]){

        QueueUsingStackEnqueue queue=new QueueUsingStackEnqueue();

         Scanner sc = new Scanner(System.in);
        int choice = 0, num = 0;

        while (choice != 6) {
            System.out.println("***************** Menu *****************");
            System.out.println("1. Add element:");
            System.out.println("2. Delete element:");
            System.out.println("3. is queue empty?:");
            System.out.println("4. top of queue:");
            System.out.println("5. print queue:");
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
                    System.out.println("Top of queue: "+top());
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