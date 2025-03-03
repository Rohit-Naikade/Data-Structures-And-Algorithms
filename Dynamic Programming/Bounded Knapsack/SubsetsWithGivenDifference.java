import java.util.Scanner;

public class SubsetsWithGivenDifference {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        System.out.println("Enter difference:");
        int diff = sc.nextInt();

        int val[] = new int[size];
        int sum = 0;
        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i] = sc.nextInt();
            sum = sum + val[i];
        }

        //sum(subset1) + sum(subset2) = total(val);
        // + sum(subset1) - sum(subset2) = diff
        //---------------------------------------
        //2sum(subset1) = total(val) + diff
        //sum(subset1) = (total(val) + diff)/2

        //values can be divided into subsets if it is even.
        
        if((sum+diff)%2!=0){
           System.out.println("Total subsets with given difference are 0");
        }
        int subset=(sum+diff)/2;
        System.out.println("subset: "+subset);

        int dp[][]=new int[size+2][subset+2];

        for(int i=0;i<size+2;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<subset+2;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<size+1;i++){
            for(int j=0;j<=subset+1;j++){
                if(val[i-1]<=j){
                    dp[i][j]=dp[i-1][j-val[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int i=0;i<size+1;i++){
            for(int j=0; j<subset+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Total subsets with given difference are: "+dp[size][subset]);


    }
}
