import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str=sc.next();

        System.out.println("Is parenthesis valid? :"+valid(str));
            }
        
            private static boolean valid(String str) {
                
                Stack<Character> stack=new Stack<>();
                stack.push(str.charAt(0));
                int j=0;
            for(int i=1;i<str.length();i++){
                j=i;
                    if(str.charAt(i)=='('|| str.charAt(i)=='{' || str.charAt(i)=='['){
                        stack.push(str.charAt(i));
                    }else if(str.charAt(i)==']'){
                        if(!stack.isEmpty()  && stack.peek()!='['){
                            return false;
                    }else{
                        if(!stack.isEmpty())
                        stack.pop();
                    }
                    }else if(str.charAt(i)==')'){
                        if(!stack.isEmpty()  && stack.peek()!='('){
                            return false;
                    }else{
                        if(!stack.isEmpty())
                        stack.pop();
                    }
                    }else if(str.charAt(i)=='}'){
                        if(!stack.isEmpty()  && stack.peek()!='{'){
                            return false;
                    }else{
                        if(!stack.isEmpty())
                        stack.pop();
                    }
                    }
            }
            if(stack.isEmpty() && j==str.length()-1){
                return true;
            }
            return false;
            }
}
