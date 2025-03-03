import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SubarrayWithKDistinctIntegers {
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

        System.out.println("Longest ones: " + Subarrays(arr, k));
    }

    private static int Subarrays(int[] arr, int k) {
       
        Set<Integer> set=new HashSet<>();
        
        int sum=0;
        for(int i=0;i<arr.length;i++){
            set=new HashSet<>();
            for(int j=i;j<arr.length;j++){
                set.add(arr[j]);
                if(set.size()==k){
                    sum++;
                }

                if(set.size()>k){
                    break;
                }
            }
        }
        
        
        return sum;
    }
}
