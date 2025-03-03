import java.util.Scanner;

public class PrintOneToN {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number:");
        int num = sc.nextInt();

        System.out.println("from 1 to N:");
        printNum(num);
        System.out.println("from N to 1:");
        print(num);
    }

    private static void print(int num) {
        if(num==1){
            System.out.print(num+" ");
            return;
        }
        System.out.print(num+" ");
        print(num-1);
    }

    private static void printNum(int num) {
        if (num == 1) {
            System.out.print(num + " ");
            return;
        }

        printNum(num - 1);
        System.out.print(num + " ");
    }
}