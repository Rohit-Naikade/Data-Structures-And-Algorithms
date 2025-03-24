package Striver;

import java.util.*;

public class UniquePaths {

    static int res=0;
    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter m and n:");
        int m = sc.nextInt();
        int n = sc.nextInt();
        res=0;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println("No. of unique paths: " + uniquepaths(m, n, 0, 0));
    }

    private static int uniquepaths(int m, int n, int i, int j) {
        if(i==m-1 && j==n-1){
            return 1;
        }

        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        return dp[i][j]=uniquepaths(m, n, i+1, j) +  uniquepaths(m, n, i, j+1);

    }

}
