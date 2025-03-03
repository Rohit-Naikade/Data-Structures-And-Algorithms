package Striver;

import java.util.Scanner;

public class HouseRobber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Maximum Amount:" + robber(arr, size - 1));
    }

    private static int robber(int[] arr, int size) {
        if(size==0 || size==1){
            return arr[size];
        }

        int max=Integer.MIN_VALUE;

        max=Math.max(robber(arr, size-2)+arr[size], robber(arr,size-1));
        return max;
    }
}
