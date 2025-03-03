import java.util.Scanner;

public class Stack {

    static int stack[];
    static int maxSize;
    static int top;

    public Stack(int size) {
        stack = new int[10];
        top = -1;
        maxSize = size;
    }

    private boolean isEmpty() {
        return top == -1 ? true : false;
    }

    private static boolean isFull() {

        return top == maxSize - 1 ? true : false;
    }

    private void push(int num) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            stack[top] = num;
        }
    }

    private int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }

        return stack[top--];

    }

    private int peak() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }

        return stack[top];

    }

    private static void printstack() {
        System.out.print("Stack elements are:");

        for(int i=0;i<=top;i++){
            System.out.print(stack[i]+" ");
        }  

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the stack:");
        int size = sc.nextInt();

        Stack st = new Stack(size);

        int choice = 0;
        while (choice != 7) {

            System.out.println("************** Menu *************");
            System.out.println("1. check if stack is full");
            System.out.println("2. check if stack is empty");
            System.out.println("3. push an element");
            System.out.println("4. remove an element");
            System.out.println("5. return peak element");
            System.out.println("6. Print stack");
            System.out.println("7. exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (st.isFull()) {
                        System.out.println("Stack is full");
                    } else {
                        System.out.println("stack has some space left!");
                    }
                    break;
                case 2:
                    if (st.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("stack has elements!");
                    }
                    break;
                case 3:
                    System.out.print("Enter element you want to add:");
                    int num = sc.nextInt();
                    st.push(num);
                    break;
                case 4:
                    System.out.println("Popped element:" + st.pop());
                    break;
                case 5:
                    System.out.println("Peak element:" + st.peak());
                    break;
                case 6:
                    printstack();
                    break;
                case 7:
                    break;

            }
        }

    }

}