package Striver;

import java.util.*;

public class GeekTraining {

    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of days:");
        int days = sc.nextInt();

        int mat[][] = new int[days][3];
        for (int i = 0; i < days; i++) {
            System.out.println("Enter " + i + "the day points:");
            for (int j = 0; j < 3; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        dp=new int[mat.length][3];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int sum = Math.max(maxPoints(mat, 0, 0), Math.max(maxPoints(mat, 0, 1), maxPoints(mat, 0, 2)));

        
        System.out.println("Sum: " + sum);
    }

    private static int maxPoints(int[][] mat, int row, int i) {

        if(mat.length-1==row){
             return dp[row][i]=mat[row][i];
        }

        if(dp[row][i]!=-1){
            return dp[row][i];
        }

        if(i==0){
            
            return dp[row][i]=Math.max(maxPoints(mat, row+1, 1)+mat[row][i], maxPoints(mat, row+1, 2)+mat[row][i]);
            
        }else if(i==1){
 
            return dp[row][i]=Math.max(maxPoints(mat, row+1, 0)+mat[row][i], maxPoints(mat, row+1, 2)+mat[row][i]);
        }

        return dp[row][i]=Math.max(maxPoints(mat, row+1, 0)+mat[row][i], maxPoints(mat, row+1, 1)+mat[row][i]);

    }
}
