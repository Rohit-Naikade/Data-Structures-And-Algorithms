import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ArrayPermutationsII {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size:");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> ans = new ArrayList<>();
        permute(0, arr, ans);

        System.out.println(ans);

    }

    private static List<Integer> toList(int arr[]) {
        List<Integer> list = new ArrayList<>();

        for (int num : arr) {
            list.add(num);
        }

        return list;
    }

    public static boolean isDuplicate(int[] nums,int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i] == nums[end])return true;
        }
        return false;
    }

    private static void permute(int pointer, int[] arr, List<List<Integer>> ans) {
        if (pointer == arr.length) {
            List<Integer> list = toList(arr);
            System.out.println("saved: "+list);
            ans.add(list);
            return;
        }

        for (int i = pointer; i < arr.length; i++) {
            if (isDuplicate(arr, pointer, i)) {
                continue;
            }
            swap(arr, pointer, i);
            System.out.println("Before: Reached :"+Arrays.toString(arr)+" pointer: "+(pointer+1));
            permute(pointer+1, arr, ans);
            swap(arr, i, pointer);   
            System.out.println("After: Reached :"+Arrays.toString(arr)+" pointer: "+(pointer+1));
                     
        }
    }

    private static void swap(int[] arr, int src, int dest) {
        int temp=arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }
}