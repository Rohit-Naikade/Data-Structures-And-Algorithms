package MCM;

import java.util.Arrays;
import java.util.Scanner;

public class MCMRecursive {

    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("ENter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        dp=new int[1001][1001];

        for(int i=0;i<1001;i++){
            Arrays.fill(dp[i], -1);;
        }

        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println("Min. cost is: " + MCM(arr, 1, arr.length-1));

    }

    private static int MCM(int[] arr, int i, int j) {
        
        if(i>=j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        int temp=0;
        for(int k=i;k<=j-1;k++){
            System.out.println("i: "+i+" k: "+k+ " j: "+j+" arr[i-1]: "+arr[i-1]+" arr[k]: "+arr[k]+" arr[j]: "+arr[j]);

            temp=MCM(arr,i,k)+MCM(arr,k+1,j)+(arr[i-1]*arr[k]*arr[j]);
            
            min=Math.min(temp, min);
        }

        dp[i][j]=min;
        return dp[i][j];
    }
}
