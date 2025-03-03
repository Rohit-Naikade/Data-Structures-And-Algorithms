import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size:");
        int s = sc.nextInt();

        int arr[] = new int[s];

        System.out.println("Enter array elements:");
        for (int i = 0; i < s; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter size:");
        int s1 = sc.nextInt();

        int arr1[] = new int[s1];

        System.out.println("Enter array elements:");
        for (int i = 0; i < s1; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] res = findInterSection(arr, arr1);

        System.out.println("common array elements:");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    private static int[] findInterSection(int[] arr, int[] arr1) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int temp : arr) {
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            }
        }

        for (int temp : arr1) {
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }
        }

        System.out.println(map);

        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }

        int res[]=list.stream().mapToInt(Integer::intValue).toArray();
        return  res;
    }
}
