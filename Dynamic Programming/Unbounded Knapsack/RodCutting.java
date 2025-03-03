import java.util.Scanner;

public class RodCutting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int val[] = new int[size];

        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
        }
       
        int dp[][]=new int[val.length+1][size+1];

        for(int i=1;i<val.length+1;i++){
            for(int j=1;j<val.length+1;j++){
                if(i<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-i],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int i=0;i<size+1;i++){
            for(int j=0; j<size+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

}
