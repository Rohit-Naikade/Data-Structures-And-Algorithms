package Striver;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTopDown {

    static int TopDown[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number:");
        int num = sc.nextInt();

        TopDown=new int[num+1];;
        TopDown[0]=0;
        TopDown[1]=1;
        System.out.println("fibonacci sum: " + fibonacci(num));

        for(int i=0;i<num;i++){
                System.out.print(TopDown[i]+" ");
            }
            System.out.println();
    }
    

    private static int fibonacci(int num) {
        
        
        for(int i=2;i<=num;i++){
            TopDown[i]=TopDown[i-1]+TopDown[i-2];
        }
        
        return TopDown[num];
    }
}
