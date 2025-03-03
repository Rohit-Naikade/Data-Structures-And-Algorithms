import java.util.Scanner;
import java.util.Stack;

public class RemoveOuterParanthesis {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = sc.next();
        Stack<Character> stck=new Stack<>();
        StringBuilder result=new StringBuilder();

        for(char c: str.toCharArray()){
            if(c=='('){
                if(!stck.isEmpty()){
                    result.append(c);
                }
                stck.push(c);
            }else{
                stck.pop();
                if(!stck.isEmpty()){
                    result.append(c);
                }
            }
        }
        System.out.println("Removed paranthesis: " + result);
    }

}
