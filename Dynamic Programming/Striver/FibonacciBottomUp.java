package Striver;
import java.util.*;

public class FibonacciBottomUp {

    static int BottomUp[];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number:");
        int num = sc.nextInt();

        BottomUp=new int[num+1];;

        Arrays.fill(BottomUp, -1);

        System.out.println("fibonacci sum: " + fibonacci(num));

        for(int i=0;i<num;i++){
                System.out.print(BottomUp[i]+" ");
        }
    }

    private static int fibonacci(int num) {
        if(num==0 || num==1){
            return num;
        }

        if(BottomUp[num]!=-1){
            return BottomUp[num];
        }
        BottomUp[num]= fibonacci(num-1)+fibonacci(num-2);
        return BottomUp[num];
    }
}
