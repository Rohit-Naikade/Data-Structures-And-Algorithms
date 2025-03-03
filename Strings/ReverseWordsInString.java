import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter line:");
        String s=sc.nextLine();

        System.out.println(s);
        String str[]=s.split(" ");
        
        Stack<String> stck=new Stack<>();
        for(String st: str){
            stck.push(st);
        }
        System.out.println(stck);
        String res=stck.pop();
        while(!stck.isEmpty()){
            res+=" "+stck.pop();
        }

        System.out.println(res);
    }
}
