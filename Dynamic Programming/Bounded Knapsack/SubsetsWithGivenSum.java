import java.util.Scanner;

public class SubsetsWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();
        
        System.out.println("Enter sum:");
        int sum = sc.nextInt();

        int val[] = new int[size];
        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }

        int dp[][]=new int[size+2][sum+2];

        for(int i=0;i<size+2;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<size+1;i++){
            for(int j=0;j<=sum+1;j++){
                if(val[i-1]<=j){
                    dp[i][j]=dp[i-1][j-val[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int i=0;i<size+1;i++){
            for(int j=0; j<sum+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("total subsets: "+dp[size][sum]);
    }
}
