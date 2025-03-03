import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CombinationSum3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter k:");
        int k = sc.nextInt();

        int arr[] = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = i+1;
        }

        System.out.println("Enter target:");
        int target = sc.nextInt();

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();

        generate(arr, 0, templist, ansList, k, target);
        System.out.println("subsets are:" + ansList);
    }

    private static void generate(int[] arr, int ptr, List<Integer> templist, List<List<Integer>> ansList, int k, int target) {
        if(target==0 && templist.size()==k){
            ansList.add(new ArrayList<>(templist));
            return;
        }

        if(ptr>=arr.length){
            return;
        }

        if(arr[ptr]<=target){
            
            templist.add(arr[ptr]);
            System.out.println(templist);
            generate(arr, ptr+1, templist, ansList, k, target-arr[ptr]);
            templist.remove(templist.size()-1);
            System.out.println("backtrack: "+templist);
            generate(arr, ptr+1, templist, ansList, k, target);
        }
        
        
    }
}
