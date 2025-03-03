package Striver;

import java.util.Scanner;

public class MinimalCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size of an array:");
        int size = sc.nextInt();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter elements:");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Minimal Cost: " + minimalCost(k, size-1, arr));
    }

    private static int minimalCost(int k, int size, int[] arr) {
        if(size==0) return 0;

        int cost=Integer.MAX_VALUE;
        for(int i=1;i<=Math.min(size, k);i++){
            cost=Math.min(cost, minimalCost(k, size-i, arr)+Math.abs(arr[size]-arr[size-i]));
            System.out.println("cost:" +cost+" length:"+size);
        }

        return cost;
    }
}
