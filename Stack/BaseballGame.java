import java.util.Scanner;

public class BaseballGame {

    static int stack[]=new int[20];
    static int maxSize=40;
    static int top=-1;

    public static boolean isEmpty() {
        return top == -1 ? true : false;
    }

    public static boolean isFull() {

        return top == maxSize - 1 ? true : false;
    }

    public static void push(int num) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            stack[top] = num;
        }
    }

    public static int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }

        return stack[top--];
    }

    public static int peak() {
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
        Scanner sc=new Scanner(System.in);


        System.out.println("Enter operations length");
        int num=sc.nextInt();

        for(int i=0;i<num;i++){
            String c=sc.next();

            if(c.equals("C")){
                pop();
                System.out.println("Score invalidated");
                printstack();
            }else if(c.equals("D")){
                push(peak()*2);
                System.out.println("Score doubled");
                printstack();
            }else if(c.equals("+")){

                int num1=top>=0?stack[top]:0;
                int num2=top>=1?stack[top-1]:0;
                push(num1+num2);

                System.out.println("Score added");
                printstack();
            }else{
                push(Integer.parseInt(c));
                System.out.println("Score recorded");
                printstack();
            }
        }

        int total=0;

        while(top>=0){
            total=total+pop();
        }

        System.out.println("Final Score:"+total);
    }
}
