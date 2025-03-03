import java.util.HashMap;
import java.util.Scanner;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array:");
        int s1 = sc.nextInt();

        int nums1[] = new int[s1];

        System.out.println("Enter first array elements:");
        for (int i = 0; i < s1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array:");
        int s2 = sc.nextInt();

        int nums2[] = new int[s2];

        System.out.println("Enter second array elements:");
        for (int i = 0; i < s2; i++) {
            nums2[i] = sc.nextInt();
        }

        nums1 = nextGreaterElement(nums1, nums2);

        System.out.println("Next greater elements:");

        for (int i = 0; i < s1; i++) {
            System.out.print(nums1[i] + " ");
        }

    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = findNextGreater(nums1[i],nums2);
        }

        return nums1;
    }

    private static int findNextGreater(int num, int nums2[]) {

        int max=-1;
        for(int i=nums2.length-1;i>=0;i--){
            if(num<nums2[i]){
                max=nums2[i];
            }

            if(num==nums2[i]){
                break;
            }
        }

        return max;
        
    }
}
