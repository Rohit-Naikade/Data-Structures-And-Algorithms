import java.util.Arrays;
import java.util.Scanner;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String S:");
        String s=sc.next();
        System.out.println("Enter String T:");
        String t=sc.next();

        int dp[][]=new int[s.length()+1][t.length()+1];
        Arrays.fill(dp[0], 0);

        for(int i=0;i<s.length()+1;i++){
            dp[i][0]=1;
        }

        System.out.println("DP before filling:");

        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<t.length()+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<t.length()+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        System.out.println("DP after filling:");

        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<t.length()+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }
}
