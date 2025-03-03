package LCS;

import java.util.Arrays;
import java.util.Scanner;

public class LCSTopDown {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter first String:");
        String s1=sc.next();

        System.out.println("Enter second String:");
        String s2=sc.next();

        int dp[][]=new int[s1.length()+1][s2.length()+1];

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println("Length of LCS: "+dp[s1.length()][s2.length()]);

        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
