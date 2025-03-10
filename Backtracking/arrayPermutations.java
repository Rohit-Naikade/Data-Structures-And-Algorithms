import java.util.*;

public class arrayPermutations {
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

    private static void permute(int index, int[] arr, List<List<Integer>> ans) {
        if (index == arr.length) {
            List<Integer> res = toList(arr);
            ans.add(res);
            return;

        }

        for (int i = index; i < arr.length; i++) {
            swap(index, i, arr);
            permute(index + 1, arr, ans);
            swap(i, index, arr);
        }
    }

    private static void swap(int src, int dest, int[] arr) {
        int temp=arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
