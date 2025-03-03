import java.util.Arrays;
import java.util.Scanner;

public class ObtainMaxPointsFromCards {
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

        System.out.println("Maximum points: " + maxPoints(arr, k));
    }

    private static int maxPoints(int[] arr, int k) {

        int temp=0, left=0, right=0, sum=0, answer=Integer.MIN_VALUE;
        int window=arr.length-k;

        int totalPts=Arrays.stream(arr).sum();

        if(arr.length==k){
            return totalPts;
        }
        while(right<arr.length){
            temp++;
            sum+=arr[right];
            if(temp==window){
                answer=Math.max(answer, totalPts-sum);
                sum-=arr[left];
                left++;
                temp--;

            }

            right++;
        }
        
        
        return answer;
    }
}
