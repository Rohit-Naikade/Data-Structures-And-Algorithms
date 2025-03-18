//https://www.geeksforgeeks.org/problems/binary-search-trees/1

import java.util.Scanner;

public class IdentifyBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter Array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("is array BST? " + isBSTTraversal(arr));
    }

    private static boolean isBSTTraversal(int[] arr) {
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>=arr[i+1]){
                return false;
            }
        }

        return true;

    }
}
