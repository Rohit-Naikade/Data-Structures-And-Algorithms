
//N Digit numbers with digits in increasing order
//Given an integer n, print all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

import java.util.*;

public class NDigitNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n:");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        // String str="";
        // if(n==1){
        //     str="0";
        //     list.add(0);
        // }else{
        //     for (int i=1;i<=n;i++) {
        //         str+=i;
        //     }
        // }
        solve("", 0, 0, n, list);

        System.out.println("Result is:");
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }

    private static void solve(String str, int start, int digits, int max, ArrayList<Integer> list) {
        if(start>9 || digits>max){
            return;
        }
        System.out.println("str: "+str);
        if(digits==max){
            list.add(Integer.parseInt(str));
        }

        for(int i=start; i<=9;i++){
             if(!str.equals("0") && str.length()!=0 && str.charAt(str.length()-1) - '0' < i){
                solve(str+i, i, digits+1, max, list);
             }else if(str.length()==0){
                 solve(str+i, i, digits+1, max, list);
              }
                        
        }

    }
}
