package LCS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintLongestSubsequence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter first String:");
        String s1=sc.next();

        System.out.println("Enter second String:");
        String s2=sc.next();

        int dp[][]=new int[s1.length()+1][s2.length()+1];

        String temp="";
        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int m=s1.length(), n=s2.length();
        while(m>0 && n>0){
            if(s1.charAt(m-1)==s2.charAt(n-1)){
                temp+=s1.charAt(m-1);
                m--;
                n--;
            }else{
                if(dp[m][n-1]>dp[m-1][n]){
                    n--;
                }else{
                    m--;
                }
            }
        }

        
        System.out.println("Longest Common subsequence: "+new StringBuilder(temp).reverse());

        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
