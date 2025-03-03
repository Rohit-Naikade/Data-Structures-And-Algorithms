import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int m = sc.nextInt();

        System.out.println("Enter array's elements:");
        int nums[] = new int[m];

        for (int i = 0; i < m; i++) {
            nums[i] = sc.nextInt();
        }

        quicksort(nums, 0, nums.length - 1);
        System.out.println("Sorted array's elements:");
        for (int i = 0; i < m; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("Majority Element: "+majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
         int majority=nums.length/2;

          return nums[majority];
    }

    private static void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);

            quicksort(nums, low, pi - 1);
            quicksort(nums, pi + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
