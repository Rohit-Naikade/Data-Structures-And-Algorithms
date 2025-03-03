import java.util.Scanner;
import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the stack:");
        int size = sc.nextInt();

        Stack<Integer> stack = new Stack();

        int tmp = 0;
        System.out.println("Enter stack elements:");
        for (int i = 0; i < size; i++) {
            tmp = sc.nextInt();
            stack.push(tmp);
        }

        System.out.println("stack before sort" + stack);
        reverse(stack);

        System.out.println("stack elements are:");

        for (Integer temp : stack) {
            System.out.print(temp + " ");
        }

    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.size()==0){
            return;
        }

        int nm=stack.pop();
        reverse(stack);

        Stack<Integer> st=new Stack<>();

        while(stack.size()>0 && stack.peek()<nm){
            st.push(stack.pop());
        }

        stack.push(nm);
        System.out.println("stack: "+ stack);
        System.out.println("st: "+ stack);
        while(st.size()>0){
            stack.push(st.pop());
        }
    }
}
