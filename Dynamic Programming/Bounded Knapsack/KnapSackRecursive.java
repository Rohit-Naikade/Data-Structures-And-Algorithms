import java.util.Scanner;

class KnapSackRecursive {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        System.out.println("Enter capacity:");
        int capacity = sc.nextInt();

        int val[] = new int[size];
        int wt[] = new int[size];

        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }

        System.out.println("Enter weights:");
        for (int i = 0; i < size; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Max. profit is:" + knapSack(capacity, val, wt, val.length-1));
    }

    private static int knapSack(int capacity, int[] val, int[] wt, int n) {
        if(capacity==0 || n<0){
            return 0;
        }
        
        if(capacity>=wt[n]){
            System.out.println("value:"+val[n]+" capacity:"+capacity+" n:"+n);
            return Math.max(val[n]+knapSack(capacity-wt[n],val, wt,  n-1), 
                            knapSack(capacity,val, wt,  n-1));
        }else{
            System.out.println("value:"+val[n]+" capacity:"+capacity+" n:"+n);
            return knapSack( capacity, val, wt, n-1);
        }
    }
}