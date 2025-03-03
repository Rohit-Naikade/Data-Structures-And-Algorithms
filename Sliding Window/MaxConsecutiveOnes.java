import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter array elements:");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        System.out.println("Longest ones: " + longestOnes(arr, k));
    }

    private static int longestOnes(int[] arr, int k) {
        int max=Integer.MIN_VALUE;

        int ones=0;
        int zeros=0;

        for(int i=0;i<arr.length;i++){
            ones=0;
            zeros=0;
            for(int j=i;j<arr.length;j++){
                if(arr[j]==1){
                    ones++;
                }else if(arr[j]==0){
                    zeros++;
                }

                if(j==arr.length-1 || zeros-1==k){
                    max=Math.max(max, (ones+zeros-1));
                    break;
                }
            }
        }
        return max;
    }
}
