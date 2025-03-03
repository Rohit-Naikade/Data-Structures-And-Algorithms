import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GenerateSubsets2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();
        Arrays.sort(arr);
        generate(arr, 0, templist, ansList);
        System.out.println("subsets are:"+ansList);
    }

    private static void generate(int[] arr, int ptr, List<Integer> templist, List<List<Integer>> ansList) {
            System.out.println("adding: "+templist);
            ansList.add(new ArrayList<>(templist));
       
            for(int i=ptr;i<arr.length;i++){
                if(i>ptr && arr[i]==arr[i-1]) continue;
                templist.add(arr[ptr]);
                System.out.println(templist);
                generate(arr, i+1, templist, ansList);
                templist.remove(templist.size()-1);
                System.out.println("backtrack:"+templist);
            }
    }
}
