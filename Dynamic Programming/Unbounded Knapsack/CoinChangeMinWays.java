import java.util.*;

class CoinChangeMinWays {

    private static int[] removeZeros(int[] arr) {
        return Arrays.stream(arr).filter(x -> x != 0).toArray();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        System.out.println("Enter sum:");
        int sum = sc.nextInt();

        int val[] = new int[size];
        System.out.println("Enter values:");
        for (int i = 0; i < size; i++) {
            val[i]=sc.nextInt();
        }

        val=removeZeros(val);
        size=val.length;

        int dp[][]=new int[size+1][sum+1];

        for(int i=0;i<sum+1;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }

        dp[0][0]=0;

        for(int i=1;i<size+1;i++){
            dp[i][0]=0;
        }

        for (int i = 1; i <= sum; i++) {
            if (val.length>0 && i % val[0] == 0) {
                dp[1][i] = i / val[0]; // Only one type of coin is used
            } else {
                dp[1][i] = Integer.MAX_VALUE - 1;
            }
        }

        for(int i=0;i<size+1;i++){
            for(int j=0; j<sum+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){
                if(val[i-1]<=j){
                    dp[i][j]=Math.min(1+dp[i][j-val[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for(int i=0;i<size+1;i++){
            for(int j=0; j<sum+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Minimum ways: "+(dp[size][sum]==Integer.MAX_VALUE-1? -1 : dp[size][sum]));

    }
}
