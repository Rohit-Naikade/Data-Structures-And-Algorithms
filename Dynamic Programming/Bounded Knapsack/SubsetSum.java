import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        System.out.println("Enter capacity:");
        int target = sc.nextInt();

        int val[] = new int[size];

        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }

        boolean dp[][]=new boolean[size+2][target+2];

        for(int i=0;i<size+2;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<target+2;i++){
            dp[0][i]=false;
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<target+1;j++){
                if(val[i-1]<=j){
                    dp[i][j]= dp[i-1][j-val[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int i=0;i<size+1;i++){
            for(int j=0; j<target+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
