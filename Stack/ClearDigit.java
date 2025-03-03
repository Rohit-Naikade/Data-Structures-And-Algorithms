import java.util.*;
import java.util.Stack;

public class ClearDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENter String:");
        String str = sc.next();

        System.out.println("Result is:" + clearDigit(str));
    }

    private static String clearDigit(String str) {
        Stack<Character> st=new Stack<>();
        int tmp=0;

        for(int i=0;i<str.length();i++){
            tmp=(int) str.charAt(i);
            System.out.println(tmp+" "+str.charAt(i));
            if(tmp>=48 && tmp<=57 && !st.isEmpty()){
                st.pop();
            }else{
                st.push(str.charAt(i));
            }
        }

        String result="";

        for(int i=0;i<st.size();i++){
            result=result+st.elementAt(i);
        }

        return result;

    }
}
