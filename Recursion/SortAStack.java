import java.util.*;

public class SortAStack {
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
        sortArray(stack);

        System.out.println("stack elements are:");

        for(Integer temp : stack){
            System.out.print(temp+" ");
        }

    }

    private static void sortArray(Stack<Integer> stack) {
        if (stack.size() == 0) {
            return;
        }

        int temp = stack.peek();
        stack.pop();

        System.out.println("stack before insert:"+stack);

        sortArray(stack);

        System.out.println("stack before insert:"+stack);
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int temp) {
        if(stack.size()==0 || stack.peek()<=temp){
            stack.push(temp);
            return;
        }

        int val=stack.peek();
        stack.pop();
        System.out.println("stack during insert:"+stack+" and temp:"+temp);
        insert(stack, temp);
        stack.push(val);
    }
}
