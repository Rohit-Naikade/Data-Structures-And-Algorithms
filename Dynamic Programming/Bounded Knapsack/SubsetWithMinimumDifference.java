import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsetWithMinimumDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int val[] = new int[size];
        int sum = 0;
        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
            sum = sum + val[i];
        }
       
        boolean dp[][]=new boolean[size+2][sum+2];

        for(int i=0;i<size+2;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<sum+2;i++){
            dp[0][i]=false;
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){
                if(val[i-1]<=j){
                    dp[i][j]=dp[i-1][j-val[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        List<Integer> ls=new ArrayList<>();

        for(int i=0;i<=sum/2;i++){
            if(dp[size][i]){
                ls.add(i);
            }
        }

        System.out.println(ls);

        int min=Integer.MAX_VALUE;

        for(Integer num: ls){
            min=Math.min(min, sum-2*num);
        }

        System.out.println("Minimum difference: "+min);
    }
}
