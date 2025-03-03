import java.util.*;
import java.util.List;
import java.util.Scanner;

public class StringPermutations2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = sc.next();

        List<String> list = new ArrayList<>();

        permut(str.toCharArray(), 0, list);

        for (String st : list) {
            System.out.print(st + " ");
        }
    }

    private static void permut(char input[], int start, List<String> list) {
        if (start == input.length) {

            String s="";
            for(char c: input){
                s=s+c;
            }
            list.add(s);
            return;
        }

        Set<Character> set = new LinkedHashSet();

        for (int i = 0; i < input.length; i++) {

            if(start==i){
                continue;
            }
            swap(input, start, i);
            // System.out.println(newIp+" "+newOp);
            permut(input, start+1, list);
            swap(input, start, i);
            // }

        }
    }

    private static void swap(char[] input, int start, int i) {
        char c=input[start];
        input[start]=input[i];
        input[i]=c;
    }
}
