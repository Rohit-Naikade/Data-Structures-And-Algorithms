import java.util.Scanner;

class KnapSackRecursiveTopDown {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        System.out.println("Enter capacity:");
        int capacity = sc.nextInt();

        int val[] = new int[size];
        int wt[] = new int[size];
        int dp[][]=new int[wt.length+2][capacity+2];
        
        for(int i=0;i<wt.length+2;i++){
            for(int j=0;j<capacity+2;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }

        System.out.println("Enter weights:");
        for (int i = 0; i < size; i++) {
            wt[i] = sc.nextInt();
        }

        for(int i=0;i<wt.length+2;i++){
            for(int j=0; j<capacity+2;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }


        for(int i=1;i<wt.length+1;i++){
            for(int j=1; j<capacity+1;j++){
                if(j>=wt[i-1]){
                   dp[i][j]=Math.max(val[i-1]+ dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int i=0;i<wt.length+2;i++){
            for(int j=0; j<capacity+2;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Max. profit is:" + dp[wt.length][capacity]);
    }
}