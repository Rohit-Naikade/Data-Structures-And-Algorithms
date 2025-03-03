import java.util.Scanner;

public class PowOfX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        int num = sc.nextInt();

        System.out.println("Enter n:");
        int n = sc.nextInt();

        System.out.println(n + "th Power of " + num + " is:" + pow(num, n));
    }

    private static int pow(int num, int n) {
        if(n==0){
            return 1;
        }

        int nm=pow(num, n/2);

        
        if(n%2==0){
            System.out.println("n: "+n+" nm:"+nm+" ans:"+(nm*nm));
            return nm*nm;
        }else{
            System.out.println("n: "+n+" nm:"+nm+" ans:"+(nm*nm*n));
            return nm*nm*num;
        }
    }
}
