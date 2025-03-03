import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter target:");
        int target = sc.nextInt();

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> templist = new ArrayList<>();

        generate(arr, 0, templist, ansList, target);
        System.out.println("subsets are:" + ansList);
    }

    private static void generate(int[] arr, int ptr, List<Integer> templist, List<List<Integer>> ansList, int target) {
        if(target==0){
            ansList.add(new ArrayList<>(templist));
            return;
        }
        if(target==0 && ptr>=arr.length){
            ansList.add(new ArrayList<>(templist));
            return;
        }

        if(ptr>=arr.length){
            return;
        }
        System.out.println(templist);
        if((target-arr[ptr])>=0){
            templist.add(arr[ptr]);
            generate(arr, ptr, templist, ansList, target-arr[ptr]);
            templist.remove(templist.size()-1);
        }
        generate(arr, ptr+1, templist, ansList, target);
    }
}
