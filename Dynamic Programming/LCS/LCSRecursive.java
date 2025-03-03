package LCS;

import java.util.Arrays;
import java.util.Scanner;

public class LCSRecursive {

    static int dp[][];
    public static int LCS(String s1, String s2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }

        if(dp[n-1][m-1]!=-1){
            return dp[n-1][m-1];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            dp[n-1][m-1]=1+LCS(s1, s2, n-1, m-1);
            return dp[n-1][m-1];
        }else{
            dp[n-1][m-1]=Math.max(LCS(s1, s2, n-1, m), LCS(s1, s2, n, m-1));
            return dp[n-1][m-1];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter first String:");
        String s1=sc.next();

        System.out.println("Enter second String:");
        String s2=sc.next();

        dp=new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<s1.length()+1;i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Length of LCS: "+LCS(s1, s2, s1.length(), s2.length()));

        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
