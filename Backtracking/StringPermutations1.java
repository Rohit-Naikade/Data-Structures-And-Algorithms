import java.util.*;
import java.util.List;
import java.util.Scanner;

public class StringPermutations1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = sc.next();

        List<String> list = new ArrayList<>();

        permut("", str, list);

        for(String st : list){
            System.out.print(st+" ");
        }
    }

    private static void permut(String output, String input, List<String> list) {
        if(input.length()==0){
            list.add(output);
            return;
        }

        Set<Character> set=new LinkedHashSet();

        for(int i=0;i<input.length();i++){

            if(!set.contains(input.charAt(i))){
                set.add(input.charAt(i));
                String newIp=input.substring(0, i)+input.substring(i+1);
            String newOp=output+input.charAt(i);
            //System.out.println(newIp+" "+newOp);
            permut(newOp, newIp, list);
            }
            
        }
    }
}
